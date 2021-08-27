package com.mercadolibre.calculadoracalorias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> demoException(MethodArgumentNotValidException e){
        Logger.getGlobal().info(e.getFieldError().getDefaultMessage());
        return ResponseEntity.ok("alskjd");
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected void demoException2(HttpMessageNotReadableException e){
        System.out.println(e.getCause().getMessage());
    }
}
