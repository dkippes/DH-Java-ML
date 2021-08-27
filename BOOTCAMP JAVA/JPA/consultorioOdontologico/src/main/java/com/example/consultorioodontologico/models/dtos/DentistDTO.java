package com.example.consultorioodontologico.models.dtos;

import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Long id;

    private String name;

    List<TimeTableDAO> timetable;
}
