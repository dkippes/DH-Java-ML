package com.example.mvcinyecciondependencias.controllers;

import com.example.mvcinyecciondependencias.services.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/constructor")
public class ConstructorController {

    IUserService userService; // Ya no instancia, hace un BEAN en el Stack

    public ConstructorController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testInyDep() {
        return this.getClass().getSimpleName() + " : " + userService.responseID() + " - " + userService.toString();
    }

}
