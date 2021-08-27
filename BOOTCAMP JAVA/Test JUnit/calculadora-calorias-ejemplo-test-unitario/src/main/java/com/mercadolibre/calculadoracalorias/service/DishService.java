package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.Exceptions.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;

import java.util.List;

public interface DishService {
  DishResponseDTO calculateCalories(DishDTO dish) throws NotFoundException;

  List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) throws NotFoundException;
}
