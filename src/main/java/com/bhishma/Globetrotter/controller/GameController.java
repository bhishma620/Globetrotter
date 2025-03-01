package com.bhishma.Globetrotter.controller;

import com.bhishma.Globetrotter.response.GameValidation;
import com.bhishma.Globetrotter.response.LoadResponse;
import com.bhishma.Globetrotter.request.Score;
import com.bhishma.Globetrotter.service.GameService;
import com.bhishma.Globetrotter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @GetMapping("/load")
    ResponseEntity<LoadResponse> loadGame(){
        return gameService.loadGame();
    }

    @GetMapping("/isValid")
    ResponseEntity<GameValidation> isValid(@RequestParam("id") Long id,
                                           @RequestParam("answer") String answer){
        return gameService.isValid(id, answer);
    }


    @GetMapping("/score")
    ResponseEntity<Score> getScore(@RequestParam("userId") String userId,
                                   @RequestParam("ts") Long timestamp){
        return userService.getScore(userId,timestamp);
    }


}
