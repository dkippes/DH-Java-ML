package com.example.consultorioodontologico.services.implementations;

import com.example.consultorioodontologico.exceptions.DateErrorException;
import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.exceptions.TimeTableNotFoundException;
import com.example.consultorioodontologico.models.daos.ReprogrammedDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import com.example.consultorioodontologico.models.dtos.ReprogrammedDTO;
import com.example.consultorioodontologico.models.dtos.TurnoDTO;
import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.PatientDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.repositories.IConsultorioRepository;
import com.example.consultorioodontologico.services.IConsultorioService;
import com.example.consultorioodontologico.services.IDentistService;
import com.example.consultorioodontologico.services.IPatientService;
import com.example.consultorioodontologico.services.IReprogrammedTurnService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ConsultorioServiceImpl implements IConsultorioService {
    IConsultorioRepository consultorioRepository;
    IPatientService patientService;
    IDentistService dentistService;
    IReprogrammedTurnService reprogrammedTurnService;
    ModelMapper mapper;

    public ConsultorioServiceImpl(IConsultorioRepository consultorioRepository, IPatientService patientService, IDentistService dentistService, IReprogrammedTurnService reprogrammedTurnService, ModelMapper mapper) {
        this.consultorioRepository = consultorioRepository;
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.reprogrammedTurnService = reprogrammedTurnService;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void createTurn(TurnoDTO turno) throws PatientNotFoundException, DentistNotFoundException, DateErrorException {
        TimeTableDAO timeTableDAO = new TimeTableDAO();
        PatientDAO patient = patientService.findPatientById(turno.getId_patient());
        DentistDAO dentist = dentistService.findDentistById(turno.getId_dentist());
        timeTableDAO.setDentist(dentist);
        timeTableDAO.setPatient(patient);
        timeTableDAO.setStatus("Pendiente");
        timeTableDAO.setDate(turno.getDateArrange());
        Date date30MinAfter = new Date(timeTableDAO.getDate().getTime() + (long) (29 * 60 * 1000));
        Date date30MinBefore = new Date(timeTableDAO.getDate().getTime() - (long) (29 * 60 * 1000));
        List<TimeTableDAO> turn = consultorioRepository.findTimeTableDAOByDateBetween30min(timeTableDAO.getDentist(), date30MinBefore, date30MinAfter);
        if(turn.size() > 0)
            throw new DateErrorException();
        consultorioRepository.save(timeTableDAO);
    }

    @Override
    public void cancelateTurn(Long id) throws TimeTableNotFoundException {
        TimeTableDAO timeTable = consultorioRepository.findTimeTableDAOByIdAndStatusOrStatus(id, "Pendiente", "Reprogramado");
        if(Objects.isNull(timeTable))
            throw new TimeTableNotFoundException();
        timeTable.setStatus("Cancelado");
        consultorioRepository.save(timeTable);
    }

    @Override
    public void doneTurn(Long id) throws TimeTableNotFoundException {
        TimeTableDAO timeTable = consultorioRepository.findTimeTableDAOByIdAndStatusOrStatus(id, "Pendiente", "Reprogramado");
        if(Objects.isNull(timeTable))
            throw new TimeTableNotFoundException();
        timeTable.setStatus("Finalizado");
        consultorioRepository.save(timeTable);
    }

    @Override
    public void reprogrammedTurn(Long id, ReprogrammedDTO reprogrammed) throws TimeTableNotFoundException, DateErrorException {
        TimeTableDAO timeTable = consultorioRepository.findTimeTableDAOByIdAndStatusOrStatus(id, "Pendiente", "Reprogramado");
        if(Objects.isNull(timeTable))
            throw new TimeTableNotFoundException();

        Date date30MinAfter = new Date(reprogrammed.getDate().getTime() + (long) (29 * 60 * 1000));
        Date date30MinBefore = new Date(reprogrammed.getDate().getTime() - (long) (29 * 60 * 1000));
        List<TimeTableDAO> turn = consultorioRepository.findTimeTableDAOByDateBetween30min(timeTable.getDentist(), date30MinBefore, date30MinAfter);
        if(turn.size() > 0)
            throw new DateErrorException();

        ReprogrammedDAO reprogrammedDAO = mapper.map(reprogrammed, ReprogrammedDAO.class);
        reprogrammedTurnService.reprogrammedTurn(reprogrammedDAO);
        timeTable.setDate(reprogrammedDAO.getDate());
        timeTable.setStatus("Reprogramado");
        timeTable.setReprogrammed(reprogrammedDAO);
        consultorioRepository.save(timeTable);
    }

    @Override
    public List<TimeTableDAO> doneTurns() {
        return consultorioRepository.findAllByStatus("Finalizado");
    }

    @Override
    public List<TimeTableDAO> pendientTurns(Date date) {
        Date dateFinal = new Date(date.getTime() + (long) (24 * 60 * 60 * 1000));
        return consultorioRepository.findTimeTableDAOByStatusInDate("Pendiente", date, dateFinal);
    }

    @Override
    public List<TimeTableDAO> reprogrammedTurns() {
        return consultorioRepository.findAllByStatus("Reprogramado");
    }
}
