package com.example.consultorioodontologico.services;

import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;

import java.util.Date;
import java.util.List;

public interface IDentistService {
    void createDentist(DentistDAO dentist);
    void editDentist(Long id, String name) throws DentistNotFoundException;
    void deleteDentist(Long id) throws DentistNotFoundException;

    DentistDAO findDentistById(Long id) throws DentistNotFoundException;

    List<DentistDAO> findDentists();

    List<DentistDAO> with2TurnsInDate(Date date);

    DentistDTO findDentistByIdAndAgenda(Long id) throws DentistNotFoundException;

    DentistDTO reprogrammedTurnsByDentist(Long id) throws DentistNotFoundException;
}
