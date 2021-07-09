package com.example.demo.controller;

import com.example.demo.dtos.AnimalDTO;
import com.example.demo.services.AnimalService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/constructor")
public class ConstructorController{

    AnimalService animalService;

    public ConstructorController(@Qualifier("pato") AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/{animal}")
    public AnimalDTO buscarAnimal(@PathVariable String animal){
        return new AnimalDTO(
                animalService.cantidadDePatas(animal),
                animalService.hacerRuido(animal),
                animalService.toString()
        );
    }
}
