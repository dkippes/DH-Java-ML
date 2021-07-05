package com.example.codigomorse.controllers;

import com.example.codigomorse.models.CodigoMorse;
import com.example.codigomorse.utils.MorseConverse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CodigoMorseController {

    @PostMapping("/codigoMorse")
    public CodigoMorse codigificarACaracter(
            @RequestParam(value = "morse", defaultValue = "") String morse
    ) {
        var ascii = MorseConverse.converseToAscii(morse);
        return new CodigoMorse(morse, ascii, "El mensaje ha sido traducido");
    }
}
