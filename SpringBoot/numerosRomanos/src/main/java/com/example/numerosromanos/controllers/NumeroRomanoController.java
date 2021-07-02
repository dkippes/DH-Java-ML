package com.example.numerosromanos.controllers;

import com.example.numerosromanos.models.NumeroRomano;
import com.example.numerosromanos.utils.ConversorDeNumeros;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class NumeroRomanoController {

    @GetMapping("/numeroACambiar/{numeroDecimal}")
    public NumeroRomano numeroDecimalARomano(
            @PathVariable("numeroDecimal") String numero
    ) {
        try {
            var numeroRomano = ConversorDeNumeros.convertirANumerosRomanos(Integer.parseInt(numero));
            return new NumeroRomano( Integer.parseInt(numero), numeroRomano, "Se ha convertido el numero a romano");
        } catch (Exception ex) {
            return new NumeroRomano("No se ha podido convertir a romano");
        }
    }

    @GetMapping("/numeroACambiar")
    public NumeroRomano numeroRomanoADecimal(
            @RequestParam(value = "numeroRomano") String numero
    ) {
        try {
            var numeroDecimal = ConversorDeNumeros.romanConvert(numero);
            return new NumeroRomano( numeroDecimal, numero, "Se ha convertido el numero a decimal");
        } catch (Exception ex) {
            return new NumeroRomano("No se ha podido convertir a decimal");
        }
    }
}
