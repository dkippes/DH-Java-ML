package com.example.consultorioodontologico.exceptions;

public class DentistNotFoundException extends Throwable {
    public final String ERROR = "DentistDAO No Found in database";

    public DentistNotFoundException() {
        super();
    }
}
