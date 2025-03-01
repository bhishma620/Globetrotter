package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.response.GameValidation;
import com.bhishma.Globetrotter.response.LoadResponse;
import org.springframework.http.ResponseEntity;

public interface GameService {
    ResponseEntity<LoadResponse> loadGame();
    ResponseEntity<GameValidation> isValid(Long id, String answer);
}
