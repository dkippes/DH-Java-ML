package com.example.numerosromanos.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumeroRomano {
    private Integer numeroDecimal;
    private String numeroRomano;
    private String mensaje;

    public NumeroRomano(String mensaje) {
        this.mensaje = mensaje;
    }
}
