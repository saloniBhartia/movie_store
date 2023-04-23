package com.movie.store.viewModel;

import com.movie.store.databaseRepository.MovieRepository;
import com.movie.store.datamodel.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieStore {

    @Autowired
    MovieRepository movieRepository;

    public List<Movies> getMovieDetails(String movieName) {
        List<Movies> moviesList = new ArrayList<>();
        movieRepository.findAll().forEach(movies -> {
            if(movies.getTitle().equals(movieName)) {
                moviesList.add(movies);
            }
        });
        return moviesList;
    }

    public List<Movies> getMoviesByYear(Integer year) {
        List<Movies> moviesList = new ArrayList<>();
        movieRepository.findAll().forEach(movies -> {
            if(Objects.equals(movies.getYear(), year)) {
                moviesList.add(movies);
            }
        });
        return moviesList;
    }

    public List<Movies> getMoviesByCast(String castName) {
        List<Movies> moviesList = new ArrayList<>();
        movieRepository.findAll().forEach(movies -> {
            if(movies.getCast().contains(castName)) {
                moviesList.add(movies);
            }
        });
        return moviesList;
    }

    public List<Movies> getMoviesByGenre(String genre) {
        List<Movies> moviesList = new ArrayList<>();
        movieRepository.findAll().forEach(movies -> {
            if(movies.getGenres().contains(genre)) {
                moviesList.add(movies);
            }
        });
        return moviesList;
    }
}
