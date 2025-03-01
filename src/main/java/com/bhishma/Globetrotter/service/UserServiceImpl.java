package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.entity.User;
import com.bhishma.Globetrotter.repo.UserRepo;
import com.bhishma.Globetrotter.request.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<String> register(User user) {
        userRepo.save(user);

        return new ResponseEntity<>("Saved", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Score> getScore(String userId, Long timestamp) {

        Optional<User> user = userRepo.findByUserIdAndTimestamp(userId, timestamp);
        Score response = new Score();
        if (user.isPresent()) {
            response.setScore(user.get().getScore());
            response.setUserName(user.get().getUserId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
