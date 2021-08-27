package com.example.consultorioodontologicomongo.services;

import com.example.consultorioodontologicomongo.models.daos.TurnDAO;
import com.example.consultorioodontologicomongo.models.dtos.DoctorDTO;
import com.example.consultorioodontologicomongo.models.dtos.DoctorTurnsRespDTO;
import com.example.consultorioodontologicomongo.models.dtos.TurnDTO;

import java.util.List;

public interface ITurnService {
    void saveTurn(TurnDTO turn);

    void editTurn(String id, TurnDTO turn) throws Exception;

    void deleteTurn(String id) throws Exception;

    List<TurnDTO> allTurns();

    List<TurnDTO> allTurnsWithStatus(String status);

    DoctorTurnsRespDTO doctorTurns(DoctorDTO doctor);

    DoctorTurnsRespDTO doctorLastNameTurns(String lastName) throws Exception;

    DoctorTurnsRespDTO doctorLastNameStatusTurns(String lastName, String status) throws Exception;

    DoctorDTO getDoctor(String lastName) throws Exception;
}
