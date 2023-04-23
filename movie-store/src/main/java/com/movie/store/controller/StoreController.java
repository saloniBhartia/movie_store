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
    public ResponseEntity<List<Movies>> getMovieDetails(@RequestParam String movieName) {
        try {
            return ResponseEntity.ok(movieStore.getMovieDetails(movieName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/year")
    public ResponseEntity<List<Movies>> getMoviesByYear(@RequestParam Integer year) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByYear(year));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/cast")
    public ResponseEntity<List<Movies>> getMoviesByCast(@RequestParam String cast) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByCast(cast));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Movies>> getMoviesByGenre(@RequestParam String genre) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByGenre(genre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
