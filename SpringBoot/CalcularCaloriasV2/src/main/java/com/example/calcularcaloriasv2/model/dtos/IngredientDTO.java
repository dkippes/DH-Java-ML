package com.example.calcularcaloriasv2.model.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IngredientDTO {
    private String name;
    private Integer weigth;
    private Integer calories;
}
