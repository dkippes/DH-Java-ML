package com.example.calculadoraspring.dtos.response;

import com.example.calculadoraspring.dtos.request.HabitacionRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CasaResponseDto {

    private Double cantidadTotalMetrosCuadrados;
    private String valorCasa;
    private HabitacionRequestDto habitacionMasGrande;
    private List<HabitacionResponseDto> cantidadDeMetrosCuadradosPorHabitacion;

}
