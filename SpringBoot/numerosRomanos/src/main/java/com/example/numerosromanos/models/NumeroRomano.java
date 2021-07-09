package com.example.numerosromanos.models;

import lombok.*;

@Data // Data trae un toString
// @Getter
// @Setter
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
