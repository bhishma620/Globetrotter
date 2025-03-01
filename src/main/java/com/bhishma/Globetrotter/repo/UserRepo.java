package com.bhishma.Globetrotter.repo;


import com.bhishma.Globetrotter.entity.User;
import com.bhishma.Globetrotter.request.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("SELECT s FROM User s WHERE s.userId= :userId AND s.timestamp = :timestamp")

    Optional<User> findByUserIdAndTimestamp(String userId, Long timestamp);
}
