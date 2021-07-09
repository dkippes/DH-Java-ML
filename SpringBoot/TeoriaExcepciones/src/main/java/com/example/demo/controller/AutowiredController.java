package com.example.demo.controller;

import com.example.demo.dtos.AnimalDTO;
import com.example.demo.exceptions.MultiplicarExceptions;
import com.example.demo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowired")
public class AutowiredController{

    @Autowired
    @Qualifier("perro")
    AnimalService animalService;

    @GetMapping("/{animal}")
    public AnimalDTO buscarAnimal(@PathVariable String animal){
        return new AnimalDTO(
                animalService.cantidadDePatas(animal),
                animalService.hacerRuido(animal),
                animalService.toString()
        );
    }

    @GetMapping("/{num1}/{num2}")
    public String calcular(@PathVariable Integer num1 , @PathVariable Integer num2) throws MultiplicarExceptions{
        Integer multiplicacion = 0;
        if(num1 != 0 && num2 != 0)
            multiplicacion = num1 * num2;
        else
            throw new MultiplicarExceptions();

        return multiplicacion.toString();

    }


}
