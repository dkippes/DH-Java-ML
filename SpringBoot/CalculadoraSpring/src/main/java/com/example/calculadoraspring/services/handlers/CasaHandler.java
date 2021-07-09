package com.example.calculadoraspring.services.handlers;

import com.example.calculadoraspring.dtos.request.*;
import com.example.calculadoraspring.dtos.response.HabitacionResponseDto;

import java.util.*;

public class CasaHandler {

    public static Double cantidadTotalMetrosCuadrados(CasaRequestDto casa) {
        var habitaciones = casa.getHabitaciones();
        Double total = 0.0;
        for ( HabitacionRequestDto habitacion : habitaciones) {
            total += (Double) (habitacion.getAncho() * habitacion.getLargo());
        }
        return total;
    }

    public static String valorDeLaCasa(CasaRequestDto casa) {
        var cantidadDeMetrosCuadrados = cantidadTotalMetrosCuadrados(casa);
        final Integer DOLAR = 800;
        var valorCasa = cantidadDeMetrosCuadrados / 1000 * DOLAR;
        return "U$D " + valorCasa;
    }

    public static HabitacionRequestDto habitacionMasGrande(CasaRequestDto casa) {
        HabitacionRequestDto habitacionMasGrande = new HabitacionRequestDto("Sin habitacion", 0.0, 0.0);
        var habitaciones = casa.getHabitaciones();
        for (HabitacionRequestDto habitacion : habitaciones) {
            Double habitacionMasGrandeMtsCuadrados = (Double) habitacionMasGrande.getLargo() * habitacionMasGrande.getAncho();
            if (habitacionMasGrandeMtsCuadrados < (Double) (habitacion.getLargo() * habitacion.getAncho())) {
                habitacionMasGrande = habitacion;
            }
        }
        return habitacionMasGrande;
    }

    public static List<HabitacionResponseDto> cantidadDeMetrosCuadradosPorHabitacion(CasaRequestDto casa) {
        var habitaciones = casa.getHabitaciones();
        List<HabitacionResponseDto> listaDeHabitacionesMtsCuadrado = new ArrayList<>();

        for (HabitacionRequestDto habitacion : habitaciones) {
            Double cantidadMtsCuadrado = habitacion.getAncho() * habitacion.getLargo();
            listaDeHabitacionesMtsCuadrado.add(new HabitacionResponseDto(habitacion.getNombre(), cantidadMtsCuadrado));
        }
        return listaDeHabitacionesMtsCuadrado;
    }

}
