package com.example.starwars.repository;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;

import java.util.List;

public interface CharactersRepository {

    List<StarWarsCharacterDTO> findCharacterByName(NameRequestDTO name);
}
