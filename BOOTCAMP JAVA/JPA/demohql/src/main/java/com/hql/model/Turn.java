package com.hql.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turn {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    private LocalDate date;
}
