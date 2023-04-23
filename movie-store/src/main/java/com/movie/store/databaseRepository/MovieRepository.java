package com.movie.store.databaseRepository;

import com.movie.store.datamodel.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movies, Integer> {
}
