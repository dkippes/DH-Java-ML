package com.example.consultorioodontologicomongo.models.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDAO {
    private String firstName;
    private String lastName;
    private Double age;
    private String gender;
}
