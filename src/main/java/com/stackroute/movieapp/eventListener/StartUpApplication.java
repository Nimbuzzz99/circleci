package com.stackroute.movieapp.eventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;


@Component
public class StartUpApplication implements
  ApplicationListener<ContextRefreshedEvent> {
    
	@Autowired
	private MovieRepository movieRepo;
 
    @Override 
    public void onApplicationEvent(ContextRefreshedEvent event) {
		movieRepo.save(new Movie(5,"jdjfnsd","ksnsddks","9999"," mvmdv"));
    }
    
    
}