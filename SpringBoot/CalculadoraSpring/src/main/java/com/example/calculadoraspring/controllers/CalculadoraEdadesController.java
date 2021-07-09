package com.example.calculadoraspring.controllers;

import com.example.calculadoraspring.dtos.response.EdadResponseDto;
import com.example.calculadoraspring.routes.Router;
import com.example.calculadoraspring.services.handlers.EdadHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController()
@RequestMapping(Router.BASE)
public class CalculadoraEdadesController {

    @PostMapping(Router.CALCULAREDAD)
    public ResponseEntity<EdadResponseDto> calcularEdad(
            @PathVariable @Min(value = 1, message = "a") @Max(value = 31, message = "_") Integer dia,
            @PathVariable @Min(1) @Max(12) Integer mes,
            @PathVariable @Min(1900) Integer anio
    ){
        EdadResponseDto edadResponseDto = new EdadResponseDto(
                EdadHandler.calcularEdad(dia, mes, anio)
        );
        return new ResponseEntity<>(edadResponseDto, HttpStatus.OK);
    }
}
