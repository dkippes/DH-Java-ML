package com.example.consultorioodontologicomongo.repositories;

import com.example.consultorioodontologicomongo.models.daos.DoctorDAO;
import com.example.consultorioodontologicomongo.models.daos.TurnDAO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnRepository extends MongoRepository<TurnDAO, ObjectId> {

    List<TurnDAO> findTurnDAOByStatus(String status);

    List<TurnDAO> findTurnDAOByDoctor(DoctorDAO doctorDAO);

    @Query(value = "{'doctor.lastName': ?0 }")
    List<TurnDAO> findTurnDAOByDoctorLastName(String lastName);

    @Query(value = "{'doctor.lastName': ?0, 'status': ?1 }")
    List<TurnDAO> findTurnDAOByDoctorLastNameAndStatus(String lastName, String status);

    @Query(value = "{'doctor.lastName': ?0 }", fields = "{ doctor: 1 }")
    List<TurnDAO> findTurnDAOByDoctorDTObyLastName(String lastName);
}
