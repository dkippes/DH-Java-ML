package com.example.starwars.services;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;
import com.example.starwars.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{
    CharactersRepository charactersRepository;

    public SearchServiceImpl(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Override
    public List<StarWarsCharacterDTO> searchCharacter(NameRequestDTO name) {
        return charactersRepository.findCharacterByName(name);
    }

}
