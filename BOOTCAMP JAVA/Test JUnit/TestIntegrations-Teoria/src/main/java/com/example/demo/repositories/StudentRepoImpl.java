package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepoImpl implements StudentRepository{
    @Override
    public String saveStudentRepo(){
        return "Guardado";
    }
}
