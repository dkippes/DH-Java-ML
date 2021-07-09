package com.example.mvcinyecciondependencias.services;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Override
    public String responseID() {
        // Aca va a estar la logica de negocio
        return "Inyeccion de Dependencia Completa";
    }
}
