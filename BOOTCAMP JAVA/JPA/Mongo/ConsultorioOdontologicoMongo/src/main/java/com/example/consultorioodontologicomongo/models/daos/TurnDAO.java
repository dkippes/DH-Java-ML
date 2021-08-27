package com.example.consultorioodontologicomongo.models.daos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "turns")
public class TurnDAO {
    @MongoId
    private ObjectId id;

    @Field(name = "patient")
    private PatientDAO patient;

    @Field(name = "doctor")
    private DoctorDAO doctor;

    @Field(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @Field(name = "status")
    private String status;
}
