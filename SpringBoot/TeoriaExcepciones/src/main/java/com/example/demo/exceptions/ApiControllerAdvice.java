package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice{

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ErrorMessage handler(MultiplicarExceptions ex){
        return  new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.ERROR);
    }

}
