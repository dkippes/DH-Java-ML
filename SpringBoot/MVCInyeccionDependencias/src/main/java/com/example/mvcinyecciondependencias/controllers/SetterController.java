package com.example.mvcinyecciondependencias.controllers;

import com.example.mvcinyecciondependencias.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setter")
public class SetterController {

    IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testInyDep() {
        return this.getClass().getSimpleName() + " : " + userService.responseID() + " - " + userService.toString();
    }
}
