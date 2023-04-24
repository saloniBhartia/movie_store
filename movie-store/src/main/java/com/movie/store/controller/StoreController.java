package com.movie.store.controller;


import com.movie.store.datamodel.Movies;
import com.movie.store.viewModel.MovieStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    MovieStore movieStore;

    @GetMapping("/")
    public String index() {
        return "Greetings to the movie store!";
    }

    @GetMapping("/movieName")
    public ResponseEntity<List<Movies>> getMovieDetails(@RequestParam(required = false) String movieName,
                                                        @RequestParam(required = false) Integer year,
                                                        @RequestParam(required = false) String cast,
                                                        @RequestParam(required = false) String genre) {
        try {
            return sanitizeOutput(movieStore.getMovieDetails1(movieName, year, cast, genre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }

    private ResponseEntity<List<Movies>> sanitizeOutput(List<Movies> movies) {
        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(movies);
    }

}
