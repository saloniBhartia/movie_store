package com.movie.store.controller;


import ch.qos.logback.core.spi.ErrorCodes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.store.datamodel.Movie;
import com.movie.store.viewModel.MovieStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    MovieStore movieStore;

    @GetMapping("/")
    public String index() {
        return "Greetings to the movie store!";
    }

    @GetMapping("/movieName")
    public ResponseEntity<List<Movie>> getMovieDetails(@RequestParam String movieName) {
        try {
            return ResponseEntity.ok(movieStore.getMovieDetails(movieName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/year")
    public ResponseEntity<List<Movie>> getMoviesByYear(@RequestParam Integer year) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByYear(year));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/cast")
    public ResponseEntity<List<Movie>> getMoviesByCast(@RequestParam String cast) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByCast(cast));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@RequestParam String genre) {
        try {
            return ResponseEntity.ok(movieStore.getMoviesByGenre(genre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
