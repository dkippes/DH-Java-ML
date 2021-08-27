package com.example.consultorioodontologico.exceptions;

public class TimeTableNotFoundException extends Throwable {
    public final String ERROR = "TimeTable No Found in database";

    public TimeTableNotFoundException() {
        super();
    }
}
