package com.example.consultorioodontologico.models.daos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "reprogrammed_turn")
public class ReprogrammedDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @OneToOne(mappedBy = "reprogrammed")
    @JsonBackReference
    private TimeTableDAO timeTable;
}
