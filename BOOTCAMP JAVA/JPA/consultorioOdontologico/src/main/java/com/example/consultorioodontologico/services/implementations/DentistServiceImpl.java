package com.example.consultorioodontologico.services.implementations;

import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import com.example.consultorioodontologico.repositories.IDentistRepository;
import com.example.consultorioodontologico.services.IDentistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DentistServiceImpl implements IDentistService {
    IDentistRepository dentistRepository;

    public DentistServiceImpl(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    @Transactional
    public void createDentist(DentistDAO dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    @Transactional
    public void editDentist(Long id, String name) throws DentistNotFoundException {
        DentistDAO dentist = dentistRepository.findById(id).orElseThrow(DentistNotFoundException::new);
        dentist.setName(name);
        dentistRepository.save(dentist);
    }

    @Override
    @Transactional
    public void deleteDentist(Long id) throws DentistNotFoundException {
        dentistRepository.findById(id).orElseThrow(DentistNotFoundException::new);
        dentistRepository.deleteById(id);
    }

    @Override
    @Transactional
    public DentistDAO findDentistById(Long id) throws DentistNotFoundException {
        return dentistRepository.findById(id).orElseThrow(DentistNotFoundException::new);
    }

    //Ejecicio 1: Listar todos los pacientes de un día de todos los dentistas.
    @Override
    @Transactional
    public List<DentistDAO> findDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public List<DentistDAO> with2TurnsInDate(Date date) {
        Date dateFinal = new Date(date.getTime() + (long) (24 * 60 * 60 * 1000));
        return dentistRepository.findDentistWith2TurnsInDate(date, dateFinal);
    }

    @Override
    public DentistDTO findDentistByIdAndAgenda(Long id) throws DentistNotFoundException {
        var dentist =  dentistRepository.findDentistDAOByIdInTimetable(id);
        if(dentist.size() < 1)
            throw new DentistNotFoundException();
        DentistDTO dentistDTO = new DentistDTO(dentist.get(0).getId(), dentist.get(0).getDentist().getName(), dentist);
        return dentistDTO;
    }

    @Override
    public DentistDTO reprogrammedTurnsByDentist(Long id) throws DentistNotFoundException {
        var dentistReprogrammedTurns = dentistRepository.findDentistDAOByIdInTimetableReprogrammed(id);
        if(dentistReprogrammedTurns.size() < 1)
            throw new DentistNotFoundException();
        DentistDTO dentistDTO = new DentistDTO(dentistReprogrammedTurns.get(0).getId(), dentistReprogrammedTurns.get(0).getDentist().getName(), dentistReprogrammedTurns);
        return dentistDTO;
    }
}
