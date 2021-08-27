package com.example.consultorioodontologicomongo.controllers;

import com.example.consultorioodontologicomongo.models.dtos.DoctorDTO;
import com.example.consultorioodontologicomongo.models.dtos.DoctorTurnsRespDTO;
import com.example.consultorioodontologicomongo.models.dtos.TurnDTO;
import com.example.consultorioodontologicomongo.services.ITurnService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnRestController {
    ITurnService turnService;

    public TurnRestController(ITurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTurn(@RequestBody TurnDTO turn) {
        turnService.saveTurn(turn);
        return new ResponseEntity<>("turn created", HttpStatus.OK);
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity<String> editTurn(@PathVariable String id, @RequestBody TurnDTO turn) throws Exception {
        turnService.editTurn(id, turn);
        return new ResponseEntity<>("turn edited", HttpStatus.OK);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<String> deleteTurn(@PathVariable String id) throws Exception {
        turnService.deleteTurn(id);
        return new ResponseEntity<>("turn deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TurnDTO>> allTurns() {
        return new ResponseEntity<>(turnService.allTurns(), HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<TurnDTO>> statusTurns(@PathVariable String status) {
        return new ResponseEntity<>(turnService.allTurnsWithStatus(status), HttpStatus.OK);
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorTurnsRespDTO> doctorTurns(@RequestBody DoctorDTO doctorDTO) {
        return new ResponseEntity<>(turnService.doctorTurns(doctorDTO), HttpStatus.OK);
    }

    @GetMapping("/doctor/{lastName}")
    public ResponseEntity<DoctorTurnsRespDTO> doctorLastNameTurns(@PathVariable String lastName) throws Exception {
        return new ResponseEntity<>(turnService.doctorLastNameTurns(lastName), HttpStatus.OK);
    }

    @GetMapping("/doctor/{lastName}/{status}")
    public ResponseEntity<DoctorTurnsRespDTO> doctorLastNameStatusTurns(@PathVariable String lastName, @PathVariable String status) throws Exception {
        return new ResponseEntity<>(turnService.doctorLastNameStatusTurns(lastName, status), HttpStatus.OK);
    }

    @GetMapping("/getDoctor/{lastName}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable String lastName) throws Exception {
        return new ResponseEntity<>(turnService.getDoctor(lastName), HttpStatus.OK);
    }
}
