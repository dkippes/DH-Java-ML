package com.example.calculadoraspring.services.handlers;

import java.time.LocalDate;
import java.time.Period;

public class EdadHandler {
    public static Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return edad.getYears();
    }
}
