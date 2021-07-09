package com.example.starwars.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameRequestDTO {

    @NotNull(message = "Debe existir el atributo name")
    @NotBlank(message = "No puede estar vacio")
    private String name;

}
