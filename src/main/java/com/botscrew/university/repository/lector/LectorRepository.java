package com.botscrew.university.repository.lector;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {

    @Query("FROM Lector l WHERE LOWER(l.name) LIKE CONCAT('%', LOWER(?1),'%')")
    List<Lector> findByLectorName(String lectorName);

}