package com.bhishma.Globetrotter.repo;

import com.bhishma.Globetrotter.entity.Clue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClueRepo extends JpaRepository<Clue, Long> {


    @Query("SELECT c.text FROM Clue c WHERE c.destId = :destId")
    List<String> findByDestId(@Param("destId") Long destId);
}
