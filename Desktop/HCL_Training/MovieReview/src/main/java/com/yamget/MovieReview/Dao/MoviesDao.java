package com.yamget.MovieReview.Dao;

import java.util.List;

import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.MovieUserRel;

public interface MoviesDao {

	public List<Movie> getAllMovies();
	
	public Movie getMovieById(int movie_id);
	
	public boolean insertMovie(Movie movie);
	
	public Movie addMovie(Movie movie);
	
	public boolean updateMovie(Movie movie);
	
	public List<MovieComment> getCommentsByMovieId(int movie_id);
	
	public boolean addMovieComment(MovieComment comment);
	
	public MovieComment insertMovieComment(MovieComment comment);

	public boolean addMovieCommentLike(int comment_id);	

	public boolean addMovieCommentDislike(int comment_id);

	public boolean addWatchedMovie(MovieUserRel mur);

	public List<Movie> getAllMoviesByLoggedInUser(int user_id);

	public List<Movie> getMyMovies(int user_id);
}
