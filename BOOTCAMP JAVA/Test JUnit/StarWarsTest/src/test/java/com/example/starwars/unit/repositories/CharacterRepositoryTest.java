package com.example.starwars.unit.repositories;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;
import com.example.starwars.repository.CharacterRepositoryImpl;
import com.example.starwars.repository.CharactersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Unit Test - Startwars Repository")
public class CharacterRepositoryTest {

    CharacterRepositoryImpl repo = new CharacterRepositoryImpl();

    @Test
    void findCharacterByName() {
        //arrange
        NameRequestDTO name = new NameRequestDTO("Luke");

        //act
        var foundCharacter = repo.findCharacterByName(name);
        List<StarWarsCharacterDTO> expectedCharacters = new ArrayList<>();
        expectedCharacters.add(new StarWarsCharacterDTO("Luke Skywalker", "172", "77", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human"));

        //assert
        Assertions.assertEquals(expectedCharacters, foundCharacter);
    }

    @Test
    void notFound() {
        //arrange
        NameRequestDTO name = new NameRequestDTO("Not Found");

        //act
        var foundCharacter = repo.findCharacterByName(name);
        List<StarWarsCharacterDTO> expectedCharacters = new ArrayList<>();

        //assert
        Assertions.assertEquals(expectedCharacters, foundCharacter);
    }
}
