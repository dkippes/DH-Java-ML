package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.PlatoDTO;
import com.mercadolibre.calculadoracalorias.dto.PlatoResponseDTO;

import java.util.List;

public interface IPlatoService {

  PlatoResponseDTO calculateCalories(PlatoDTO dish);
  List<PlatoResponseDTO> calculateAllCalories(List<PlatoDTO> dishes);

}
