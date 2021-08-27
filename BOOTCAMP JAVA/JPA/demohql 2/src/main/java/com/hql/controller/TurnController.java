package com.hql.controller;

import com.hql.model.dto.MessageDTO;
import com.hql.model.dto.TurnDTO;
import com.hql.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turn")
public class TurnController {

    @Autowired
    TurnService turnService;

    @GetMapping("/list")
    public Set<TurnDTO> getAllTurns() {
        return turnService.getAllTurns();
    }

    @GetMapping("/{id}")
    public TurnDTO getTurn(@PathVariable Long id) {
        return turnService.getTurnById(id);
    }

    @PostMapping("/create")
    public TurnDTO createTurn(@RequestBody TurnDTO turnDTO) {
        return turnService.saveTurn(turnDTO);
    }

    @DeleteMapping("/delete/{id}")
    public MessageDTO deleteTurn(@PathVariable Long id) {
        turnService.deleteTurnById(id);
        return new MessageDTO("Correct Delete");
    }

}
