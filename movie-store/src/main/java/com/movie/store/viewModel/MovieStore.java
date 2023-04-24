package com.movie.store.viewModel;

import com.movie.store.databaseRepository.MovieRepository;
import com.movie.store.datamodel.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieStore {

    @Autowired
    MovieRepository movieRepository;

    public List<Movies> getMovieDetails1(String movieName, Integer year, String cast, String genre) {
        return movieRepository.findAll().stream()
                .filter(a -> isNullOrEmpty(movieName) || a.getTitle().equalsIgnoreCase(movieName))
                .filter(a -> (year == null) || Objects.equals(a.getYear(), year))
                .filter(a -> isNullOrEmpty(cast) || a.getCast().contains(cast))
                .filter(a -> isNullOrEmpty(genre) || a.getGenres().contains(genre))
                .collect(Collectors.toList());
    }

    private boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty();
    }
}
