package com.example.calcularcaloriasv2.controllers;

import com.example.calcularcaloriasv2.exceptions.IngredientNotFoundExceptions;
import com.example.calcularcaloriasv2.model.dtos.DishDTO;
import com.example.calcularcaloriasv2.model.dtos.DishResponseDTO;
import com.example.calcularcaloriasv2.services.DishCaloriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularCaloriasRestController {

    DishCaloriesService dishCaloriesService;

    public CalcularCaloriasRestController(DishCaloriesService dishCaloriesService) {
        this.dishCaloriesService = dishCaloriesService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<DishResponseDTO> calculateTotalCalories(
            @RequestBody DishDTO dish
    ) throws IngredientNotFoundExceptions {
        return new ResponseEntity<>(dishCaloriesService.calculateTotalCaloriesInDish(dish), HttpStatus.ACCEPTED);
    }
}
