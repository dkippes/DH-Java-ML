package com.hql.repository;

import com.hql.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findDoctorByName(String name);

    Set<Doctor> findDoctorByNameStartingWith(String name);

    @Query("FROM Doctor d WHERE d.name = :name")
    Doctor buscarDoctorPorNombre(String name);

    @Query("FROM Doctor d WHERE d.name = :name")
    Doctor buscarDoctorPorNombre2(@Param("name") String first_name);

    @Query("SELECT new com.hql.model.Doctor(d.name) FROM Doctor d WHERE d.name = :name")
    Optional<Doctor> buscarDoctorPorNombre3(String name);

    @Query(value = "SELECT * FROM doctor d where d.name = ?", nativeQuery = true)
    Doctor buscarDoctorPorNombre4(String name);
}
