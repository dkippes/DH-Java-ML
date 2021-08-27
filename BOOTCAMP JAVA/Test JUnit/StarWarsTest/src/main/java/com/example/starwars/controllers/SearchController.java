package com.example.starwars.controllers;

import com.example.starwars.dto.NameRequestDTO;
import com.example.starwars.dto.StarWarsCharacterDTO;
import com.example.starwars.services.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/searchCharacter")
    public ResponseEntity<List<StarWarsCharacterDTO>> searchStarWarsCharacterCoincidences(
            @Valid @RequestBody NameRequestDTO name
    ){
        // Tuve que pasarlo a un Object porque me devolvia un String { "name": "Luke" } y no podia capturar el String
        return new ResponseEntity<>(searchService.searchCharacter(name), HttpStatus.ACCEPTED);
    }
}
