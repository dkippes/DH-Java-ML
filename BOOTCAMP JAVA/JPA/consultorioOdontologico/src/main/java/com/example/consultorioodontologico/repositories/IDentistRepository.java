package com.example.consultorioodontologico.repositories;

import com.example.consultorioodontologico.models.daos.DentistDAO;
import com.example.consultorioodontologico.models.daos.TimeTableDAO;
import com.example.consultorioodontologico.models.dtos.DentistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistRepository extends JpaRepository<DentistDAO, Long> {
    @Query("SELECT d " +
            "FROM DentistDAO d " +
            "INNER JOIN TimeTableDAO t ON t.dentist = d " +
            "WHERE t.date BETWEEN :date_initial AND :date_final " +
            "GROUP BY d " +
            "HAVING COUNT(d) >= 2")
    List<DentistDAO> findDentistWith2TurnsInDate(Date date_initial, Date date_final);

    @Query("SELECT distinct(d.timetable) FROM DentistDAO d INNER JOIN TimeTableDAO t ON t.dentist = d WHERE d.id = :id")
    List<TimeTableDAO> findDentistDAOByIdInTimetable(Long id);

    @Query("SELECT distinct(d.timetable) FROM DentistDAO d INNER JOIN TimeTableDAO t ON t.dentist = d WHERE d.id = :id AND t.status = 'Reprogramado'")
    List<TimeTableDAO> findDentistDAOByIdInTimetableReprogrammed(Long id);
}
