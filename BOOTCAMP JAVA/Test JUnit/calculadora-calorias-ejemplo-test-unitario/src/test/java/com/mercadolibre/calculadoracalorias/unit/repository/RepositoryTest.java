package com.mercadolibre.calculadoracalorias.unit.repository;

import com.mercadolibre.calculadoracalorias.Exceptions.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Tet - Ingreditnet Repository Impl")
public class RepositoryTest {

    IngredientRepositoryImpl repo = new IngredientRepositoryImpl();

//    @BeforeEach
//    void setup(){
//
//    }

    @Test
    @DisplayName("Found Ingredient by Name")
    void foundIngredient() throws NotFoundException {
        //arrange

        String ingredientName = "demo";
//        Integer expected = 120;
        IngredientDTO expected =  new IngredientDTO("demo2", 120);

        //act
        IngredientDTO current = repo.findIngredientByName(ingredientName);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @DisplayName("Found Ingredient by Name - 2")
    void foundIngredient2() throws NotFoundException {
        //arrange

        String ingredientName = "demo";
        Integer expectedCalories = 1202;
        String expectedName = "demo3";

        //act
        IngredientDTO current = repo.findIngredientByName(ingredientName);

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedName, current.getName()),
                () -> Assertions.assertEquals(expectedCalories, current.getCalories())
        );

    }

    @Test
    void NotFoundIngredient(){
        //arrange
        String ingredientName = "notFound";

        //act && assert
        Assertions.assertThrows(NotFoundException.class, () -> repo.findIngredientByName(ingredientName));
    }

}
