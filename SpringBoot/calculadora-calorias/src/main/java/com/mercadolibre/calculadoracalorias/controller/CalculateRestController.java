package com.mercadolibre.calculadoracalorias.controller;

import com.mercadolibre.calculadoracalorias.dto.PlatoDTO;
import com.mercadolibre.calculadoracalorias.dto.PlatoResponseDTO;
import com.mercadolibre.calculadoracalorias.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateRestController {
  private final IPlatoService IPlatoService;

  public CalculateRestController(IPlatoService IPlatoService) {
    this.IPlatoService = IPlatoService;
  }

  @PostMapping("/calculate")
  public ResponseEntity<PlatoResponseDTO> calculate(@RequestBody PlatoDTO dish){
    System.out.println("dish" + dish);
    return new ResponseEntity<>(IPlatoService.calculateCalories(dish), HttpStatus.OK);
  }

  @PostMapping("/calculateAll")
  public List<PlatoResponseDTO> calculate(@RequestBody List<PlatoDTO> dishes){
    return IPlatoService.calculateAllCalories(dishes);
  }
}
