package com.example.consultorioodontologico.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Data
public class TurnoDTO {
    private Long id_patient;
    private Long id_dentist;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Date dateArrange;
}
