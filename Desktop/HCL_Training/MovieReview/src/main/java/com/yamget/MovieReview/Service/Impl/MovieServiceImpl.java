package com.yamget.MovieReview.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamget.MovieReview.Dao.MoviesDao;
import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.MovieUserRel;
import com.yamget.MovieReview.Service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MoviesDao movieDao;

	public List<Movie> getAllMovies() {
		
		return movieDao.getAllMovies();
	}

	public Movie getMovieById(int movie_id) {
		
		return movieDao.getMovieById(movie_id);
	}

	public boolean insertMovie(Movie movie) {
		
		return movieDao.insertMovie(movie);
	}

	public boolean updateMovie(Movie movie) {
		
		return movieDao.updateMovie(movie);
	}

	public List<MovieComment> getCommentsByMovieId(int movie_id) {
		
		return movieDao.getCommentsByMovieId(movie_id);
	}

	public boolean addMovieComment(MovieComment comment) {
		
		return movieDao.addMovieComment(comment);
	}

	public Movie addMovie(Movie movie) {
		
		return movieDao.addMovie(movie);
	}

	public MovieComment insertMovieComment(MovieComment comment) {
		
		return movieDao.insertMovieComment(comment);
	}

	public boolean addMovieCommentLike(int comment_id) {
		
		return movieDao.addMovieCommentLike(comment_id);
	}

	public boolean addMovieCommentDislike(int comment_id) {
		
		return movieDao.addMovieCommentDislike(comment_id);
	}

	public boolean addWatchedMovie(MovieUserRel mur) {
		
		return movieDao.addWatchedMovie(mur);
	}

	public List<Movie> getAllMoviesByLoggedInUser(int user_id) {
		
		return movieDao.getAllMoviesByLoggedInUser(user_id);
	}

	public List<Movie> getMyMovies(int user_id) {
		
		return movieDao.getMyMovies(user_id);
	}

}
