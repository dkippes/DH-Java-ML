package com.example.consultorioodontologicomongo.models.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDAO {
    private String firstName;
    private String lastName;
    private String specialty;
}
