package com.example.consultorioodontologicomongo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private String specialty;
}
