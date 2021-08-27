package com.example.consultorioodontologico.repositories;

import com.example.consultorioodontologico.models.daos.PatientDAO;
import com.example.consultorioodontologico.models.daos.ReprogrammedDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReprogrammedTurnRepository extends JpaRepository<ReprogrammedDAO, Long> {
}
