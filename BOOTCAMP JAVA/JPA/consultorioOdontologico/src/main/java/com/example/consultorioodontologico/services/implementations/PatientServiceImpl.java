package com.example.consultorioodontologico.services.implementations;

import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.models.daos.PatientDAO;
import com.example.consultorioodontologico.repositories.IPatientRepository;
import com.example.consultorioodontologico.services.IPatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {
    IPatientRepository patientRepository;

    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void createPatient(PatientDAO patient) {
        patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void editPatient(Long id, String name) throws PatientNotFoundException {
        PatientDAO patient = patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
        patient.setName(name);
        patientRepository.save(patient);
    }

    @Override
    @Transactional
    public void deletePatient(Long id) throws PatientNotFoundException {
        patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
        patientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PatientDAO findPatientById(Long id) throws PatientNotFoundException {
        return patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    @Transactional
    public List<PatientDAO> findPatients() {
        return patientRepository.findAll();
    }
}
