package com.example.consultorioodontologico.models.daos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "timetables")
public class TimeTableDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonManagedReference
    private PatientDAO patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false)
    @JsonManagedReference
    private DentistDAO dentist;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne()
    @JoinColumn(name = "reprogrammed_id", referencedColumnName = "id")
    @JsonManagedReference
    private ReprogrammedDAO reprogrammed;
}
