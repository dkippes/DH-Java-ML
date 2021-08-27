package com.example.consultorioodontologico.controllers;

import com.example.consultorioodontologico.exceptions.DateErrorException;
import com.example.consultorioodontologico.exceptions.DentistNotFoundException;
import com.example.consultorioodontologico.exceptions.PatientNotFoundException;
import com.example.consultorioodontologico.exceptions.TimeTableNotFoundException;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import com.example.consultorioodontologico.models.dtos.ReprogrammedDTO;
import com.example.consultorioodontologico.models.dtos.TurnoDTO;
import com.example.consultorioodontologico.services.IConsultorioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioRestController {
    IConsultorioService consultorioService;

    public ConsultorioRestController(IConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTimetableFor___(@RequestBody TurnoDTO turno) throws DentistNotFoundException, PatientNotFoundException, DateErrorException, ParseException {
        consultorioService.createTurn(turno);
        return new ResponseEntity<>("timetable created", HttpStatus.OK);
    }

    @GetMapping("/{id}/cancel")
    public ResponseEntity<String> cancelateTurn(@PathVariable Long id) throws TimeTableNotFoundException {
        consultorioService.cancelateTurn(id);
        return new ResponseEntity<>("timetable cancelated", HttpStatus.OK);
    }

    @GetMapping("/{id}/done")
    public ResponseEntity<String> doneTurn(@PathVariable Long id) throws TimeTableNotFoundException {
        consultorioService.doneTurn(id);
        return new ResponseEntity<>("timetable done", HttpStatus.OK);
    }

    @GetMapping("/done")
    public ResponseEntity<List<TimeTableDAO>> doneTurns() {
        return new ResponseEntity<>(consultorioService.doneTurns(), HttpStatus.OK);
    }

    @PostMapping("/{id}/reprogrammed")
    public ResponseEntity<String> reprogrammedTurn(@PathVariable Long id, @RequestBody ReprogrammedDTO reprogrammed) throws TimeTableNotFoundException, DateErrorException {
        consultorioService.reprogrammedTurn(id, reprogrammed);
        return new ResponseEntity<>("timetable reprogrammed", HttpStatus.OK);
    }

    @GetMapping("/pendient")
    public ResponseEntity<List<TimeTableDAO>> pendientTurn(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return new ResponseEntity<>(consultorioService.pendientTurns(date), HttpStatus.OK);
    }

    @GetMapping("/reprogrammeds")
    public ResponseEntity<List<TimeTableDAO>> reprogrammedTurns() {
        return new ResponseEntity<>(consultorioService.reprogrammedTurns(), HttpStatus.OK);
    }
}
