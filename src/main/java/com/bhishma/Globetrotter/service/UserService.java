package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.entity.User;
import com.bhishma.Globetrotter.request.Score;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> register(User user);

    ResponseEntity<Score> getScore(String userId,Long timestamp);
}
