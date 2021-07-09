package com.example.calculadoraspring.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class HabitacionRequestDto {

    private String nombre;
    private Double ancho;
    private Double largo;

}
