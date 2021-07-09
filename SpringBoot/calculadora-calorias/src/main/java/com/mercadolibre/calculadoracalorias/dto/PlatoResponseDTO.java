package com.mercadolibre.calculadoracalorias.dto;

public class PlatoResponseDTO extends PlatoDTO {
  private Integer calories;
  private IngredientDTO caloric;

  public PlatoResponseDTO(PlatoDTO dish) {
    this.setIngredients(dish.getIngredients());
    this.setName(dish.getName());
  }

  public PlatoResponseDTO() {
  }

  public Integer getCalories() {
    return calories;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }

  public IngredientDTO getCaloric() {
    return caloric;
  }

  public void setCaloric(IngredientDTO caloric) {
    this.caloric = caloric;
  }
}
