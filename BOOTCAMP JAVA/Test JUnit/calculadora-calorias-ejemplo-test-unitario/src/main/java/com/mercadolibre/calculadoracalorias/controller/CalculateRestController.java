package com.mercadolibre.calculadoracalorias.controller;

import com.mercadolibre.calculadoracalorias.Exceptions.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.service.DishService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CalculateRestController {
  private final DishService dishService;

  public CalculateRestController(DishService dishService) {
    this.dishService = dishService;
  }

  @GetMapping("/lala")
  public String lala() {
    return "lala";
  }

  @PostMapping("/calculate")
  public DishResponseDTO calculate(@RequestBody @Valid DishDTO dish) throws NotFoundException {
    return dishService.calculateCalories(dish);
  }

  @PostMapping("/calculateAll")
  public List<DishResponseDTO> calculate(@RequestBody List<DishDTO> dishes) throws NotFoundException {
    return dishService.calculateAllCalories(dishes);
  }
}
