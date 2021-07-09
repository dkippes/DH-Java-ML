package com.example.calcularcaloriasv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage ingredientNotFound(IngredientNotFoundExceptions ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.ERROR);
    }
}
