package com.example.jpademo.services;

import com.example.jpademo.models.Student;
import com.example.jpademo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository stuRepo;

    public StudentServiceImpl(@Qualifier("studentRepository") StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
