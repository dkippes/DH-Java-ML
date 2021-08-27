package com.example.consultorioodontologico.exceptions;

public class DateErrorException extends Throwable {
    public final String ERROR = "Date is should be 30 min difference between 2 timetables";

    public DateErrorException() {
        super();
    }
}
