package com.example.starwars.unit.services;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;
import com.example.starwars.repository.CharactersRepository;
import com.example.starwars.services.SearchService;
import com.example.starwars.services.SearchServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Unit Test - Search Service")
@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    CharactersRepository charactersRepository;

    @InjectMocks
    SearchServiceImpl searchService;

    @Test
    void searchCharacter() {
        //arrange
        NameRequestDTO name = new NameRequestDTO("Luke");
        List<StarWarsCharacterDTO> expectedCharacters = new ArrayList<>();
        expectedCharacters.add(new StarWarsCharacterDTO("Luke Skywalker", "172", "77", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human"));


        //act
        Mockito.when(charactersRepository.findCharacterByName(name)).thenReturn(expectedCharacters);
        List<StarWarsCharacterDTO> currentList = searchService.searchCharacter(name);

        //assert
        Mockito.verify(charactersRepository, Mockito.atLeast(1)).findCharacterByName(Mockito.any());
        Assertions.assertEquals(expectedCharacters, currentList);
    }

    @Test
    void notFoundSearchCharacter() {
        //arrange
        NameRequestDTO name = new NameRequestDTO("Lukas");
        List<StarWarsCharacterDTO> expectedCharacters = new ArrayList<>();

        //act
        Mockito.when(charactersRepository.findCharacterByName(name)).thenReturn(expectedCharacters);
        List<StarWarsCharacterDTO> currentList = searchService.searchCharacter(name);

        //assert
        Mockito.verify(charactersRepository, Mockito.atLeastOnce()).findCharacterByName(Mockito.any());
        Assertions.assertEquals(expectedCharacters, currentList);
    }
}
