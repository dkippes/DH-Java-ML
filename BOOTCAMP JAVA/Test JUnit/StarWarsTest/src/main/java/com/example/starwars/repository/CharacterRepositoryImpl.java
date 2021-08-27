package com.example.starwars.repository;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharactersRepository{
    private final List<StarWarsCharacterDTO> database;

    public CharacterRepositoryImpl() {
        this.database = loadDatabase();
    }

    public List<StarWarsCharacterDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacterDTO>> typeReference = new TypeReference<List<StarWarsCharacterDTO>>() {
        };
        List<StarWarsCharacterDTO> starWarsCharacterDTOS = null;
        try {
            starWarsCharacterDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(starWarsCharacterDTOS);
        return starWarsCharacterDTOS;
    }

    @Override
    public List<StarWarsCharacterDTO> findCharacterByName(NameRequestDTO name) {
        List<StarWarsCharacterDTO> filteredData = database.stream()
                .filter(starWarsCharacterDTO -> starWarsCharacterDTO.getName().indexOf(name.getName()) >= 0)
                .collect(Collectors.toList());

        return filteredData;
    }
}
