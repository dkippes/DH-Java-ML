package com.hql.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnDTO {

    private Long id;

    private DoctorDTO doctor;

    private PatientDTO patient;

    private LocalDate date;
}
