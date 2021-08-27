package com.example.consultorioodontologico.repositories;

import com.example.consultorioodontologico.models.daos.PatientDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<PatientDAO, Long> {
}
