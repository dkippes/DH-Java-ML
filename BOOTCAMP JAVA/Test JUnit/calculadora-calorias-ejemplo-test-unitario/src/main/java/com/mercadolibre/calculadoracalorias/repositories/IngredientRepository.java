package com.mercadolibre.calculadoracalorias.repositories;

import com.mercadolibre.calculadoracalorias.Exceptions.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

public interface IngredientRepository {
  IngredientDTO findIngredientByName(String name) throws NotFoundException;
}
