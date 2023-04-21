package com.movie.store.viewModel;

import com.movie.store.databaseRepository.MovieRepository;
import com.movie.store.datamodel.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieStore {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovieDetails(String movieName) {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach( movie -> {
            if(movie.getTitle().equals(movieName)) {
                movieList.add(movie);
            }
        });
        return movieList;
    }

    public List<Movie> getMoviesByYear(Integer year) {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> {
            if(Objects.equals(movie.getYear(), year)) {
                movieList.add(movie);
            }
        });
        return movieList;
    }

    public List<Movie> getMoviesByCast(String castName) {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> {
            if(movie.getCast().contains(castName)) {
                movieList.add(movie);
            }
        });
        return movieList;
    }

    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> {
            if(movie.getGenres().contains(genre)) {
                movieList.add(movie);
            }
        });
        return movieList;
    }
}
