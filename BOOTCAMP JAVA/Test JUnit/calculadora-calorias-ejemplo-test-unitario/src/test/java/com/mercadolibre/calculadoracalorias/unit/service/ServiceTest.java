package com.mercadolibre.calculadoracalorias.unit.service;

import com.mercadolibre.calculadoracalorias.Exceptions.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepository;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepositoryImpl;
import com.mercadolibre.calculadoracalorias.service.DishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    IngredientRepository repo;

    @InjectMocks
    DishServiceImpl service;

    @Test
    void dishEmptyIngredients() throws NotFoundException {
        //arrange
        DishDTO dish = new DishDTO("demo", new ArrayList<>());

        //act
        DishResponseDTO current = service.calculateCalories(dish);

        //assert
        assertEquals(0, current.getCalories());
    }

    @Test
    void dishEmptyIngredients2() throws NotFoundException {
        //arrange
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO uno =  new IngredientDTO("jamon", 0, 200);
        IngredientDTO dos =  new IngredientDTO("queso", 0, 300);
        ingredients.add(uno);
        ingredients.add(dos);
        DishDTO dish = new DishDTO("demo", ingredients);

        //mocks
        IngredientDTO jamonMock = new IngredientDTO("jamon", 200);
        IngredientDTO quesoMock = new IngredientDTO("queso", 169);
        when(repo.findIngredientByName("jamon")).thenReturn(jamonMock);
        when(repo.findIngredientByName("queso")).thenReturn(quesoMock);

        //act
        DishResponseDTO current = service.calculateCalories(dish);

        //assert
        Mockito.verify(repo, Mockito.atLeast(2)).findIngredientByName(Mockito.anyString());
//        Mockito.verify(repo, Mockito.atLeastOnce()).findIngredientByName("jamon");
//        Mockito.verify(repo, Mockito.atLeastOnce()).findIngredientByName("queso");
        assertEquals(907, current.getCalories());
    }
}
