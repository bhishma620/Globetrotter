package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.entity.Destination;
import com.bhishma.Globetrotter.repo.ClueRepo;
import com.bhishma.Globetrotter.repo.DestinationRepo;
import com.bhishma.Globetrotter.repo.FunFactRepo;
import com.bhishma.Globetrotter.repo.TriviaRepo;
import com.bhishma.Globetrotter.response.GameValidation;
import com.bhishma.Globetrotter.response.LoadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private DestinationRepo destinationRepo;
    @Autowired
    private ClueRepo clueRepo;
    @Autowired
    FunFactRepo funFactRepo;
    @Autowired
    TriviaRepo triviaRepo;
    private Random random = new Random();
    @Override
    public ResponseEntity<LoadResponse> loadGame() {
        List<Destination> destinations = destinationRepo.findAll();

        LoadResponse response = new LoadResponse();
        int randomInd = getRandomInd(destinations.size());
        Long id = destinations.get(randomInd).getId();

        List<String> clues = clueRepo.findByDestId(id);

        response.setId(id);
        response.setClues(clues);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<GameValidation> isValid(Long id, String answer) {


        Optional<Destination> destination = destinationRepo.findById(id);

        if (destination.isPresent()) {
            GameValidation response = new GameValidation();
            boolean isCorrect = destination.get().getCity().equalsIgnoreCase(answer);
            response.setValid(isCorrect);
            List<String> funfacts = funFactRepo.findByDestId(destination.get().getId());
            List<String> trivals = triviaRepo.findByDestId(id);

            if (isCorrect) {
                response.setText(funfacts.get(getRandomInd(funfacts.size())));
            }
            else{
                response.setText(trivals.get(getRandomInd(funfacts.size())));
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    private int getRandomInd(int n) {
        return random.nextInt(n);
    }
}
