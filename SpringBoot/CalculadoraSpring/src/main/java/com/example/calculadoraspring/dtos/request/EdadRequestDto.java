package com.example.calculadoraspring.dtos.request;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Validated
@Getter
public class EdadRequestDto {

    private Integer dia;

    @Max(message = "Mayor a 12", value = 12)
    @Min(message = "Menor a 1", value = 1)
    private Integer mes;

    @Min(message = "Menor a 1900", value = 1900)
    @Max(message = "Mayor a 1900", value = 1900)
    private Integer anio;
}
