package com.bhishma.Globetrotter.repo;

import com.bhishma.Globetrotter.entity.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TriviaRepo extends JpaRepository<Trivia, Long> {
    @Query("SELECT t.text FROM Trivia t WHERE t.destId = :id")
    List<String> findByDestId(Long id);
}
