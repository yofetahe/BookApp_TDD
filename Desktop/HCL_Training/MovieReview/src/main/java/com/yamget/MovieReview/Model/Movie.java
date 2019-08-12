package com.yamget.MovieReview.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movie_id;
	@Column
	@NotEmpty(message="* Movie Title is required.")
	private String title;
	@Column
	@NotEmpty(message="* A minimum of one word description is required.")
	private String description;
	@Column
	@NotEmpty(message="* Movie Poster is required.")
	private String poster;
	@Column
	@NotEmpty(message="* Genres is required.")
	private String genres;
	@Column
	@NotEmpty(message="* Release year is required.")
	private int release_year;
	@Column
	@NotEmpty(message="* Produced by is required.")
	private String produced_by;
	@Column
	@NotEmpty(message="* Cost is required.")
	private double cost;
	@Column
	private double rate;
	@Column
	@NotEmpty(message="* Participants list is required.")
	private String participants;
	@Column
	private int create_by;
	
	@Transient
	private int movieuser_id;
	
	public int getMovieuser_id() {
		return movieuser_id;
	}

	public void setMovieuser_id(int movieuser_id) {
		this.movieuser_id = movieuser_id;
	}	
	
	public Movie() { }

	public Movie(int movie_id, String title, String description, String poster, String genres, int release_year, String produced_by,
			double cost, double rate, String participants, int create_by) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.description = description;
		this.poster = poster;
		this.genres = genres;
		this.release_year = release_year;
		this.produced_by = produced_by;
		this.cost = cost;
		this.rate = rate;
		this.participants = participants;
		this.create_by = create_by;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getProduced_by() {
		return produced_by;
	}

	public void setProduced_by(String produced_by) {
		this.produced_by = produced_by;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public int getCreate_by() {
		return create_by;
	}

	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
}
