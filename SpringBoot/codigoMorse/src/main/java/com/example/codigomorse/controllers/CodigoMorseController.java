package com.example.codigomorse.controllers;

import com.example.codigomorse.models.CodigoMorse;
import com.example.codigomorse.utils.MorseConverse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {

    @PostMapping("/ConClase")
    public CodigoMorse codigificarACaracterConClase(
            @RequestParam(value = "morse", defaultValue = "") String morse // RequestParam aca esta haciendo el trabajo de RequestBody
    ) {
        var ascii = MorseConverse.converseToAscii(morse);
        return new CodigoMorse(morse, ascii, "El mensaje ha sido traducido");
    }

    @GetMapping("/tipoString") // codigoMorse/tipoString?morse=...
    public String codigificarACaracterSinClase(
            @RequestParam(value = "morse", defaultValue = "") String morse
    ) {
        return MorseConverse.converseToAscii(morse);
    }

    @PostMapping("/prueba/{textoPorParametro}")
    public String prueba(
        @RequestBody String textPorBody, // Para obtener los datos via url
        @PathVariable String textoPorParametro // Para obtener los datos via body
    ) {
        return textPorBody + " " + textoPorParametro;
    }
}
