package com.example.consultorioodontologicomongo.models.dtos;

import com.example.consultorioodontologicomongo.models.daos.DoctorDAO;
import com.example.consultorioodontologicomongo.models.daos.PatientDAO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnDocRespDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Date date;
    private PatientDAO patient;
    private String status;
}
