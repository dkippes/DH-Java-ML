package com.example.consultorioodontologicomongo.services.implementations;

import com.example.consultorioodontologicomongo.models.daos.DoctorDAO;
import com.example.consultorioodontologicomongo.models.daos.TurnDAO;
import com.example.consultorioodontologicomongo.models.dtos.DoctorDTO;
import com.example.consultorioodontologicomongo.models.dtos.DoctorTurnsRespDTO;
import com.example.consultorioodontologicomongo.models.dtos.TurnDTO;
import com.example.consultorioodontologicomongo.models.dtos.TurnDocRespDTO;
import com.example.consultorioodontologicomongo.repositories.ITurnRepository;
import com.example.consultorioodontologicomongo.services.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnServiceImpl implements ITurnService {
    ITurnRepository turnRepository;
    ModelMapper mapper;

    public TurnServiceImpl(ITurnRepository turnRepository, ModelMapper mapper) {
        this.turnRepository = turnRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveTurn(TurnDTO turn) {
        TurnDAO turnDAO = mapper.map(turn, TurnDAO.class);
        turnRepository.save(turnDAO);
    }

    @Override
    public void editTurn(String id, TurnDTO turn) throws Exception {
        ObjectId objectId = new ObjectId(id);
        if(!turnRepository.existsById(objectId)) throw new Exception("No existe turno en la db");
        TurnDAO turnDAO = mapper.map(turn, TurnDAO.class);
        turnDAO.setId(objectId);
        turnRepository.save(turnDAO);
    }

    @Override
    public void deleteTurn(String id) throws Exception {
        ObjectId objectId = new ObjectId(id);
        if(!turnRepository.existsById(objectId)) throw new Exception("No existe turno en la db");
        turnRepository.deleteById(objectId);
    }

    @Override
    public List<TurnDTO> allTurns() {
        List<TurnDAO> turnDAOList = turnRepository.findAll();
        return turnDAOList.stream().map(turnDAO -> mapper.map(turnDAO, TurnDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TurnDTO> allTurnsWithStatus(String status) {
        List<TurnDAO> turnDAOList = turnRepository.findTurnDAOByStatus(status);
        return turnDAOList.stream().map(turnDAO -> mapper.map(turnDAO, TurnDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DoctorTurnsRespDTO doctorTurns(DoctorDTO doctor) {
        DoctorDAO doctorDAO = mapper.map(doctor, DoctorDAO.class);
        List<TurnDAO> turnDAOList = turnRepository.findTurnDAOByDoctor(doctorDAO);
        var turnDocRespDTOList = turnDAOList.stream().map(turnDAO -> mapper.map(turnDAO, TurnDocRespDTO.class)).collect(Collectors.toList());
        DoctorTurnsRespDTO doc = new DoctorTurnsRespDTO(doctor, turnDocRespDTOList);
        return doc;
    }

    @Override
    public DoctorTurnsRespDTO doctorLastNameTurns(String lastName) throws Exception {
        List<TurnDAO> turnDAOList = turnRepository.findTurnDAOByDoctorLastName(lastName);
        if(turnDAOList.size() <= 0)
            throw new Exception("No hay un apellido en la db");
        DoctorDTO doctorDTO = mapper.map(turnDAOList.get(0).getDoctor(), DoctorDTO.class);
        var turnDocRespDTOList = turnDAOList.stream().map(turnDAO -> mapper.map(turnDAO, TurnDocRespDTO.class)).collect(Collectors.toList());
        DoctorTurnsRespDTO doc = new DoctorTurnsRespDTO(doctorDTO, turnDocRespDTOList);
        return doc;
    }

    @Override
    public DoctorTurnsRespDTO doctorLastNameStatusTurns(String lastName, String status) throws Exception {
        List<TurnDAO> turnDAOList = turnRepository.findTurnDAOByDoctorLastNameAndStatus(lastName, status);
        if(turnDAOList.size() <= 0)
            throw new Exception("No hay un apellido en la db");
        DoctorDTO doctorDTO = mapper.map(turnDAOList.get(0).getDoctor(), DoctorDTO.class);
        var turnDocRespDTOList = turnDAOList.stream().map(turnDAO -> mapper.map(turnDAO, TurnDocRespDTO.class)).collect(Collectors.toList());
        DoctorTurnsRespDTO doc = new DoctorTurnsRespDTO(doctorDTO, turnDocRespDTOList);
        return doc;
    }

    @Override
    public DoctorDTO getDoctor(String lastName) throws Exception {
        List<TurnDAO> turnDAOList = turnRepository.findTurnDAOByDoctorDTObyLastName(lastName);
        if(turnDAOList.size() <= 0)
            throw new Exception("No hay un apellido en la db");
        return mapper.map(turnDAOList.get(0).getDoctor(), DoctorDTO.class);
    }
}
