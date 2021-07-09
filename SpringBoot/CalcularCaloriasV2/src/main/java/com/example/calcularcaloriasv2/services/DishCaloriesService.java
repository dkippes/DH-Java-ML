package com.example.calcularcaloriasv2.services;

import com.example.calcularcaloriasv2.exceptions.IngredientNotFoundExceptions;
import com.example.calcularcaloriasv2.model.dtos.DishDTO;
import com.example.calcularcaloriasv2.model.dtos.DishResponseDTO;

public interface DishCaloriesService {

    DishResponseDTO calculateTotalCaloriesInDish(DishDTO dish) throws IngredientNotFoundExceptions;
}
