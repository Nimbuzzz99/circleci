package com.stackroute.movieapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
	@Id
	private int movieId;
	private String title;
	private String imdbId;
	private String year;
	private String poster;
	
	public Movie() {
		
	}
	
	public Movie(int i ,String title, String imdbId, String year, String poster) {
		super();
		this.movieId = i;
		this.title = title;
		this.imdbId = imdbId;
		this.year = year;
		this.poster = poster;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}	
	
}
