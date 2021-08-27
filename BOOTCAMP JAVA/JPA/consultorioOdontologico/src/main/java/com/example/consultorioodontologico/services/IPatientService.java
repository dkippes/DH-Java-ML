package com.example.consultorioodontologico.services;

import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.models.daos.PatientDAO;

import java.util.List;

public interface IPatientService {
    void createPatient(PatientDAO patientDAO);
    void editPatient(Long id, String name) throws PatientNotFoundException;
    void deletePatient(Long id) throws PatientNotFoundException;

    PatientDAO findPatientById(Long id) throws PatientNotFoundException;

    List<PatientDAO> findPatients();
}
