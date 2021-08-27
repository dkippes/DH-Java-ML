package com.example.consultorioodontologico.services;

import com.example.consultorioodontologico.exceptions.DateErrorException;
import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.exceptions.TimeTableNotFoundException;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import com.example.consultorioodontologico.models.dtos.ReprogrammedDTO;
import com.example.consultorioodontologico.models.dtos.TurnoDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

public interface IConsultorioService {
    void createTurn(TurnoDTO turno) throws PatientNotFoundException, DentistNotFoundException, DateErrorException, ParseException;

    void cancelateTurn(Long id) throws TimeTableNotFoundException;

    void doneTurn(Long id) throws TimeTableNotFoundException;

    void reprogrammedTurn(Long id, ReprogrammedDTO reprogrammed) throws TimeTableNotFoundException, DateErrorException;

    List<TimeTableDAO> doneTurns();

    List<TimeTableDAO> pendientTurns(Date date);

    List<TimeTableDAO> reprogrammedTurns();
}
