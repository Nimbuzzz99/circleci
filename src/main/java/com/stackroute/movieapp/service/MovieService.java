package com.stackroute.movieapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exception.MovieAlreadyExistsException;
import com.stackroute.movieapp.exception.MovieNotFoundException;

@Service
public interface MovieService {

	public Movie addMovie(Movie movie)throws MovieAlreadyExistsException;
	public Iterable<Movie> getAllMovies();
	public boolean deleteMovie(int id)throws MovieNotFoundException;
	public Movie updateMovie(Movie movie,int id)throws MovieNotFoundException;
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
	public Optional<Movie> getMovieByTitle(String title) throws MovieNotFoundException;
}
