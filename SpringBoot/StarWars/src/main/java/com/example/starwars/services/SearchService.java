package com.example.starwars.services;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;

import java.util.List;

public interface SearchService {

    List<StarWarsCharacterDTO> searchCharacter(NameRequestDTO name);
}
