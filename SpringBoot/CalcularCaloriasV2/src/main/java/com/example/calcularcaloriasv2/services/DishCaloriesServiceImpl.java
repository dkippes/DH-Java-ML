package com.example.calcularcaloriasv2.services;

import com.example.calcularcaloriasv2.exceptions.IngredientNotFoundExceptions;
import com.example.calcularcaloriasv2.model.dtos.DishDTO;
import com.example.calcularcaloriasv2.model.dtos.DishResponseDTO;
import com.example.calcularcaloriasv2.model.dtos.IngredientDTO;
import com.example.calcularcaloriasv2.model.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishCaloriesServiceImpl implements DishCaloriesService{

    DishRepository dishRepository;

    public DishCaloriesServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public DishResponseDTO calculateTotalCaloriesInDish(DishDTO dish) throws IngredientNotFoundExceptions {
        Integer totalCalories = 0;
        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        dishResponseDTO.setName(dish.getName());
        List<IngredientDTO> listIngredientsWithCalories = new ArrayList<>();

        for (IngredientDTO ingredient : dish.getIngredients()) {
            IngredientDTO ingredientInDB = dishRepository.findIngredientByName(ingredient);
            ingredientInDB.setWeigth(ingredient.getWeigth());

            listIngredientsWithCalories.add(ingredientInDB);
            totalCalories += dishRepository.findIngredientByName(ingredient).getCalories() * ingredient.getWeigth();
        }
        dishResponseDTO.setIngredients(listIngredientsWithCalories);
        dishResponseDTO.setTotalCalories(totalCalories);


        return dishResponseDTO;
    }
}
