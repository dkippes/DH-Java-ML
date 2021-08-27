package com.example.consultorioodontologicomongo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorTurnsRespDTO {
    private DoctorDTO doctorDTO;
    private List<TurnDocRespDTO> turns;
}
