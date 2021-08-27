package com.example.consultorioodontologico.controllers;

import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.models.daos.PatientDAO;
import com.example.consultorioodontologico.services.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientRestController {
    IPatientService patientService;

    public PatientRestController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientDAO>> patients() {
        return new ResponseEntity<>(patientService.findPatients(), HttpStatus.OK);
    }

    @GetMapping("/create/{name}")
    public ResponseEntity<String> createPatient(@PathVariable String name) {
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.setName(name);
        patientService.createPatient(patientDAO);
        return new ResponseEntity<>("PatientDAO created", HttpStatus.OK);
    }

    @GetMapping("/{id}/edit/{name}")
    public ResponseEntity<String> editNamePatient(@PathVariable Long id, @PathVariable String name) throws PatientNotFoundException {
        patientService.editPatient(id, name);
        return new ResponseEntity<>("PatientDAO edited", HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws PatientNotFoundException {
        patientService.deletePatient(id);
        return new ResponseEntity<>("PatientDAO deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDAO> findPatient(@PathVariable Long id) throws PatientNotFoundException {
        return new ResponseEntity<>(patientService.findPatientById(id), HttpStatus.OK);
    }
}
