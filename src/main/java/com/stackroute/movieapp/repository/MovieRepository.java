package com.stackroute.movieapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer>{
	Optional<Movie> findByTitle(String title);
	
}
