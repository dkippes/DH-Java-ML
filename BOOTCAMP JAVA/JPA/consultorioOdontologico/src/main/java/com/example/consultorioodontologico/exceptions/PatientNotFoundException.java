package com.example.consultorioodontologico.exceptions;

public class PatientNotFoundException extends Throwable {
    public final String ERROR = "PatientDAO No Found in database";

    public PatientNotFoundException() {
        super();
    }
}
