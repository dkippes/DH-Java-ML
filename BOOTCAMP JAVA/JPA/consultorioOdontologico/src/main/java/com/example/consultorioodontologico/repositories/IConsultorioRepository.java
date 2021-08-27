package com.example.consultorioodontologico.repositories;

import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.PatientDAO;
import com.example.consultorioodontologico.models.daos.ReprogrammedDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IConsultorioRepository extends JpaRepository<TimeTableDAO, Long> {

    @Query("FROM TimeTableDAO t WHERE t.dentist = :dentist AND t.status = 'Pendiente' AND t.date BETWEEN :date1 AND :date2")
    List<TimeTableDAO> findTimeTableDAOByDateBetween30min(DentistDAO dentist, Date date1, Date date2);

    TimeTableDAO findTimeTableDAOByIdAndStatus(Long id, String status);

    TimeTableDAO findTimeTableDAOByIdAndStatusOrStatus(Long id, String status1, String status2);

    List<TimeTableDAO> findAllByStatus(String status);

    @Query("FROM TimeTableDAO t WHERE t.status = :status AND t.date BETWEEN :date_initial AND :date_final")
    List<TimeTableDAO> findTimeTableDAOByStatusInDate(String status, Date date_initial, Date date_final);
}
