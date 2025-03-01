package com.bhishma.Globetrotter.repo;

import com.bhishma.Globetrotter.entity.FunFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FunFactRepo extends JpaRepository<FunFact,Long> {

    @Query("SELECT f.text FROM FunFact f WHERE f.destId = :id")
    List<String> findByDestId(Long id);
}
