package com.example.calcularcaloriasv2.model.repository;

import com.example.calcularcaloriasv2.exceptions.IngredientNotFoundExceptions;
import com.example.calcularcaloriasv2.model.dtos.IngredientDTO;

public interface DishRepository {

    IngredientDTO findIngredientByName(IngredientDTO ingredient) throws IngredientNotFoundExceptions;
}
