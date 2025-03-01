package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.entity.*;
import com.bhishma.Globetrotter.repo.ClueRepo;
import com.bhishma.Globetrotter.repo.DestinationRepo;
import com.bhishma.Globetrotter.repo.FunFactRepo;
import com.bhishma.Globetrotter.repo.TriviaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DestinationRepo destinationRepo;
    @Autowired
    private ClueRepo clueRepo;
    @Autowired
    private FunFactRepo funFactRepo;
    @Autowired
    private TriviaRepo triviaRepo;

    public ResponseEntity<String> addData(Request destination) {
        Destination dest = new Destination();
        dest.setCity(destination.getCity());
        dest.setCountry(destination.getCountry());


        Destination savedDest = destinationRepo.save(dest);

        for(String s : destination.getClue()) {
            Clue clue = new Clue();
            clue.setText(s);
            clue.setDestId(savedDest.getId());
            clueRepo.save(clue);
        }

        for(String s : destination.getFunfact()) {
            FunFact funFact = new FunFact();
            funFact.setText(s);
            funFact.setDestId(savedDest.getId());
            funFactRepo.save(funFact);
        }

        for(String s : destination.getTrivia()) {
            Trivia trivia = new Trivia();
            trivia.setText(s);
            trivia.setDestId(savedDest.getId());
            triviaRepo.save(trivia);
        }



        return ResponseEntity.ok("Destination and related data saved successfully!");
    }

}
