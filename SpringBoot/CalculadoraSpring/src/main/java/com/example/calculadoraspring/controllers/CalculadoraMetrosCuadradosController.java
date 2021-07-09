package com.example.calculadoraspring.controllers;

import com.example.calculadoraspring.dtos.request.CasaRequestDto;
import com.example.calculadoraspring.dtos.response.CasaResponseDto;
import com.example.calculadoraspring.routes.Router;
import com.example.calculadoraspring.services.handlers.CasaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CalculadoraMetrosCuadradosController {

    @Autowired
    ICalculateService calculateService;

    @GetMapping("/{location}")
    public PriceDto calculateLocation(@PathVariable String location) {
        return calculateService.probarMapper(location);
    }

    @PostMapping(Router.METROSCUADRADOS)
    public ResponseEntity<CasaResponseDto> cantidadTotalMetrosCuadrados(
            @Valid @RequestBody CasaRequestDto casa
    ) {
        CasaResponseDto casaResponseDto = new CasaResponseDto(
                CasaHandler.cantidadTotalMetrosCuadrados(casa),
                CasaHandler.valorDeLaCasa(casa),
                CasaHandler.habitacionMasGrande(casa),
                CasaHandler.cantidadDeMetrosCuadradosPorHabitacion(casa)
        );

        return new ResponseEntity<>(casaResponseDto, HttpStatus.OK);
    }
}
