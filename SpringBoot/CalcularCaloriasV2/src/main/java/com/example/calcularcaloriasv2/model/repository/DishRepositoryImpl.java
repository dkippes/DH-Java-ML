package com.example.calcularcaloriasv2.model.repository;

import com.example.calcularcaloriasv2.exceptions.IngredientNotFoundExceptions;
import com.example.calcularcaloriasv2.model.dtos.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements DishRepository {
    private final List<IngredientDTO> database;

    public DishRepositoryImpl() {
        this.database = loadDatabase();
    }

    public List<IngredientDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:static/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<List<IngredientDTO>>() {};
        List<IngredientDTO> ingredientDTOS = null;
        try {
            ingredientDTOS = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientDTOS;
    }

    @Override
    public IngredientDTO findIngredientByName(IngredientDTO ingredient) throws IngredientNotFoundExceptions {
        Optional<IngredientDTO> ingredientFound = database.stream()
                .filter(ingredientDTO -> ingredientDTO.getName().equals(ingredient.getName()))
                .findFirst();
        IngredientDTO result = null;
        if(ingredientFound.isPresent()) {
            return ingredientFound.get();
        } else {
            throw new IngredientNotFoundExceptions();
        }
    }
}
