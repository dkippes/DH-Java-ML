package com.example.demo.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@Validated
public class StudentRequestDto{

    @Max(message = "Menor a 100", value = 100)
    @Min(message = "Mayor a 10", value = 10)
    private Long id;

    @NotNull(message = "El DNI esta nulo")
    private String dni;

    @NotBlank(message = "El nombre esta vacio")
    @NotNull(message = "El nombre esta nulo")
    private String name;

    @NotEmpty(message = "Esta coleccion esta vacio")
    private ArrayList<String> lastName;
}
