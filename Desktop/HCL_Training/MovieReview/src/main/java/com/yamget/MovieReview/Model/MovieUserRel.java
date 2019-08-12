package com.yamget.MovieReview.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieUserRel {

	@Id
	private int movieuser_id;
	private int user_id;
	private int movie_id;
	private String note;
	
	public MovieUserRel() {}
	
	public MovieUserRel(int user_id, int movie_id, String note) {
		super();
		this.user_id = user_id;
		this.movie_id = movie_id;
		this.note = note;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public int getMovieuser_id() {
		return movieuser_id;
	}

	public void setMovieuser_id(int movieuser_id) {
		this.movieuser_id = movieuser_id;
	}

	
}
