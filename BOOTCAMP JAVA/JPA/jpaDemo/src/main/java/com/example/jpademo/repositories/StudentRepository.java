package com.example.jpademo.repositories;

import com.example.jpademo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
