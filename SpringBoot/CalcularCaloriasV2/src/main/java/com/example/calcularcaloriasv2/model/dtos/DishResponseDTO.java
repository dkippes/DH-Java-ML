package com.example.calcularcaloriasv2.model.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DishResponseDTO {
    private String name;
    private List<IngredientDTO> ingredients;
    private Integer totalCalories;
}
