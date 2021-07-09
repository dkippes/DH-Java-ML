package com.example.calculadoraspring.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
@ToString
public class HabitacionResponseDto {

    private String nombre;
    private Double cantidadDeMetrosCuadrados;

}
