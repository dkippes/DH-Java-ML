package com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class DishDTO {
  @NotNull(message = "qyue paso a acas")
  @Size(max = 5, message = "Esto no debrria estar pasando")
  private String name;
  private List<IngredientDTO> ingredients;

  public DishDTO() {
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
}
