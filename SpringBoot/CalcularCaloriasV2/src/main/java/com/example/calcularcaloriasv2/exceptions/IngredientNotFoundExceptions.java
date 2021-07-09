package com.example.calcularcaloriasv2.exceptions;

public class IngredientNotFoundExceptions extends Exception{

    public final String ERROR = "No se encontro uno de los ingredientes registrados";

    public IngredientNotFoundExceptions() {
        super();
    }
}
