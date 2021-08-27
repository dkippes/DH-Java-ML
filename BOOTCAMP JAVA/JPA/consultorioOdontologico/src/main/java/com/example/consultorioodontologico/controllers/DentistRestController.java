package com.example.consultorioodontologico.controllers;

import com.example.consultorioodontologico.exceptions.DateErrorException;
import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.exceptions.TimeTableNotFoundException;
import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import com.example.consultorioodontologico.services.IDentistService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistRestController {
    IDentistService dentistService;

    public DentistRestController(IDentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping()
    public ResponseEntity<List<DentistDAO>> dentists() {
        return new ResponseEntity<>(dentistService.findDentists(), HttpStatus.OK);
    }

    @GetMapping("/with2turns")
    public ResponseEntity<List<DentistDAO>> dentistsWith2Turns(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return new ResponseEntity<>(dentistService.with2TurnsInDate(date), HttpStatus.OK);
    }

    @GetMapping("/create/{name}")
    public ResponseEntity<String> createDentist(@PathVariable String name) {
        DentistDAO dentist = new DentistDAO();
        dentist.setName(name);
        dentistService.createDentist(dentist);
        return new ResponseEntity<>("DentistDAO created", HttpStatus.OK);
    }

    @GetMapping("/{id}/edit/{name}")
    public ResponseEntity<String> editNameDentist(@PathVariable Long id, @PathVariable String name) throws DentistNotFoundException {
        dentistService.editDentist(id, name);
        return new ResponseEntity<>("DentistDAO edited", HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) throws DentistNotFoundException {
        dentistService.deleteDentist(id);
        return new ResponseEntity<>("DentistDAO deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDAO> findDentist(@PathVariable Long id) throws DentistNotFoundException {
        return new ResponseEntity<>(dentistService.findDentistById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/agenda")
    public ResponseEntity<DentistDTO> findDentistAgenda(@PathVariable Long id) throws DentistNotFoundException {
        return new ResponseEntity<>(dentistService.findDentistByIdAndAgenda(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/reprogrammed")
    public ResponseEntity<DentistDTO> reprogrammedTurnsByDentist(@PathVariable Long id) throws TimeTableNotFoundException, DateErrorException, DentistNotFoundException {
        return new ResponseEntity<>(dentistService.reprogrammedTurnsByDentist(id), HttpStatus.OK);
    }
}
