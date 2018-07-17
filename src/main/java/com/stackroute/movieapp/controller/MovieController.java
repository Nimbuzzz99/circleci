package com.stackroute.movieapp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exception.MovieAlreadyExistsException;
import com.stackroute.movieapp.exception.MovieNotFoundException;
import com.stackroute.movieapp.service.MovieService;

@RequestMapping("/api/v1")
@RestController
public class MovieController {
	
	private MovieService movieService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) 
	{
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
		try {
			return new ResponseEntity<Movie>(movieService.addMovie(movie),HttpStatus.CREATED);
		} catch (MovieAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/movies")
	public ResponseEntity<?> getMovies()
	{
		System.out.println(env.getProperty("com.stackroute.user"));
		return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id)
	{
		try {
			movieService.deleteMovie(id);
			return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable("id") int id , @RequestBody Movie movie)
	{
		try {
			movieService.updateMovie(movie, id);
			return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
		} 
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}
	
	
	@GetMapping("/movieId/{id}")
	public ResponseEntity<?> getByIdMovie(@PathVariable("id") int id)
	{
		try {
			return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/movieTitle/{title}")
	public ResponseEntity<?> getByTitleMovie(@PathVariable("title") String title)
	{
		try {
			return new ResponseEntity<Optional<Movie>>(movieService.getMovieByTitle(title),HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
