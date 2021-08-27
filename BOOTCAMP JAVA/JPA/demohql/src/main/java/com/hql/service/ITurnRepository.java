package com.hql.service;

import com.hql.model.dto.TurnDTO;

import java.util.Set;

public interface ITurnRepository {

    Set<TurnDTO> getAllTurns();

    TurnDTO getTurnById(Long id);

    TurnDTO saveTurn(TurnDTO turnDto);

    void deleteTurnById(Long id);
}
