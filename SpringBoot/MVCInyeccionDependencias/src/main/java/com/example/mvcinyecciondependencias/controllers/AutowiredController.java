package com.example.mvcinyecciondependencias.controllers;

import com.example.mvcinyecciondependencias.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// El Setter, Constructor o Autowired son lo mismo, de la misma forma generan un BEAN en el Stack
// Al no tener que crear nueva instancia por request hace que sea mas rapido y que no se genere un stackoverflow
// Es mas recomendado usar la implementacion de ConstructorController ya que aunque el autowired haga lo mismo permite hacerlo customizado - sirve para los tests.
@RestController
@RequestMapping("/autowired")
public class AutowiredController {

    @Autowired
    IUserService userService; // Ya no instancia, hace un BEAN en el Stack

    @GetMapping("/test")
    public String testInyDep() {
        return this.getClass().getSimpleName() + " : " + userService.responseID() + " - " + userService.toString();
    }
}
