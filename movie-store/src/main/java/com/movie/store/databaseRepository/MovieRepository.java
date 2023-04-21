package com.movie.store.databaseRepository;

import com.movie.store.datamodel.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer> {
}
