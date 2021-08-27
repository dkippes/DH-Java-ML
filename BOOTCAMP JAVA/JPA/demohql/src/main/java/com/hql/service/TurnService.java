package com.hql.service;

import com.hql.model.Turn;
import com.hql.model.dto.TurnDTO;
import com.hql.repository.TurnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TurnService implements ITurnRepository {

    @Autowired
    TurnRepository turnRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Set<TurnDTO> getAllTurns() {
        List<Turn> ts = turnRepository.findAll();
        return turnRepository.findAll().stream().map(turn -> mapper.map(turn, TurnDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public TurnDTO getTurnById(Long id) {
        return mapper.map(turnRepository.getById(id), TurnDTO.class);
    }

    @Override
    public TurnDTO saveTurn(TurnDTO turnDto) {
        Turn turn = mapper.map(turnDto, Turn.class);
        turn.setDate(LocalDate.now());
        turnRepository.save(turn);
        return new TurnDTO();
    }

    @Override
    public void deleteTurnById(Long id) {
        turnRepository.deleteById(id);
//        turnRepository.existsById(id);
    }

    //Mapeo de ambas direcciones
    //mapper.map(turn, TurnDTO.class);
    //mapper.map(turnDto, Turn.class);
}
