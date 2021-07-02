package com.example.demo.controllers;

import com.example.demo.models.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    private final AtomicLong contador = new AtomicLong(); // Es para numeros que cambian muy rapidamente - CONSTANTE

    // DTO - Data Transfer Object
    @GetMapping("/greeting") // Query String
    public Greeting greeing(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(contador.incrementAndGet(), "Hello " + name, this.getClass().getSimpleName());
    }

    @GetMapping("/sayBay/{nombre}/{lastName}") // Variables por parametro
    public Greeting greeing2(@PathVariable("nombre") String name, @PathVariable String lastName){
        return new Greeting(contador.incrementAndGet(), "Bay " + name + " " + lastName, this.getClass().getSimpleName());
    }

}
