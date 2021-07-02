package com.example.codigomorse.models;

import lombok.*;
import org.springframework.web.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodigoMorse {

    private String ascii;
    private String morse;
    private String mensaje;
}
