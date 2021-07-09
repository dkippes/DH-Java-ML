package com.mercadolibre.calculadoracalorias.dto;

import java.util.List;

public class PlatoDTO {
  private String name;
  private List<IngredientDTO> ingredients;

  public PlatoDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<IngredientDTO> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<IngredientDTO> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    return "PlatoDTO{" +
            "name='" + name + '\'' +
            ", ingredients=" + ingredients +
            '}';
  }
}
