package com.example.calculadoraspring.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
@Getter
public class CasaRequestDto {

    @NotBlank(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacia")
    @NotNull(message = "La direccion no puede ser nula")
    private String direccion;

    @NotNull(message = "La casa debe tener habitaciones")
    private List<HabitacionRequestDto> habitaciones;
}
