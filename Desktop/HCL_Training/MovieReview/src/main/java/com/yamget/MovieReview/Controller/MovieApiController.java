package com.yamget.MovieReview.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.MovieUserRel;
import com.yamget.MovieReview.Model.User;
import com.yamget.MovieReview.Service.MovieService;
import com.yamget.MovieReview.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class MovieApiController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/getAllMovies", produces="application/json")
	public List<Movie> getMovies() {
		
		return movieService.getAllMovies();
	}
	
	@PostMapping(value="/getAllMoviesByLoggedInUser", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces="application/json")
	public ResponseEntity<List<Movie>> getAllMoviesByLoggedInUser(@RequestBody User user){
		
		User u = userService.getUserByEmail(user);
		
		List<Movie> m = movieService.getAllMoviesByLoggedInUser(u.getUser_id());
		
		return ResponseEntity.ok(m);
	}
	
	@CrossOrigin
	@PostMapping(value="/addMovie", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces="application/json")
	public boolean addMovie(@RequestBody Movie movie) {
		
		return movieService.insertMovie(movie);
	}
	
	@CrossOrigin
	@PostMapping(value="/updateMovie/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces="application/json")
	public boolean updateMovie(@RequestBody Movie movie, @PathVariable("id") int id) {
		
		movie.setMovie_id(id);
		
		return movieService.updateMovie(movie);
	}
	
	@GetMapping(value="/comments/{id}", produces="application/json")
	public List<Object> getMovieCommentById(@PathVariable("id") int id) {
		
		List<Object> result = new ArrayList<Object>();
		Movie movie = movieService.getMovieById(id);
		List<MovieComment> comments = movieService.getCommentsByMovieId(id);
		result.add(movie);
		result.add(comments);
		
		return result;
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="/addComment", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public List<MovieComment> addComment(@RequestBody MovieComment comment) {
		
		boolean check = movieService.addMovieComment(comment);
		
		if(check)
			return movieService.getCommentsByMovieId(comment.getMovie_id());
		
		return null;
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="/addUser", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public boolean addUser(@RequestBody User user) {
		
		User u = userService.getUserByEmail(user);
		
		if(u != null) {
			return false;
		}
		
		//Password encryption
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));				
		
		return userService.insertUser(user);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="/validateUser", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public boolean validateUser(@RequestBody User user) {
		
		User u = userService.getUserByEmail(user);
		
		if(u == null) {
			return false;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		encoder.matches(user.getPassword(), u.getPassword());
		
		return encoder.matches(user.getPassword(), u.getPassword());		
	}
	
	@GetMapping(value="/getMovieById/{id}")
	public Movie getMovieById(@PathVariable("id") int id) {
		
		return movieService.getMovieById(id);
	}
	
	@GetMapping(value="/addLike/{movie_id}/{comment_id}", produces="application/json")
	public List<MovieComment> addLike(@PathVariable("movie_id") int movie_id, @PathVariable("comment_id") int comment_id){
		
		movieService.addMovieCommentLike(comment_id);
		
		return movieService.getCommentsByMovieId(movie_id);
	}
	
	@GetMapping(value="/addDislike/{movie_id}/{comment_id}", produces="application/json")
	public List<MovieComment> addDislike(@PathVariable("movie_id") int movie_id, @PathVariable("comment_id") int comment_id){
		
		movieService.addMovieCommentDislike(comment_id);
		
		return movieService.getCommentsByMovieId(movie_id);
	}
	
	@PostMapping(path="/getMyMovies", produces="application/json")
	public List<Movie> getMyMovies(@RequestBody User user) {
		
		User u = userService.getUserByEmail(user);
		
		return movieService.getMyMovies(u.getUser_id());
	} 
	
	@PostMapping(path="/watchedMovie/{movie_id}", produces="application/json", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> watchedMovies(@RequestBody User user, @PathVariable("movie_id") int movie_id) {
		
		User u = userService.getUserByEmail(user);
		
		MovieUserRel mur = new MovieUserRel();
		mur.setMovie_id(movie_id);
		mur.setUser_id(u.getUser_id());
		
		movieService.addWatchedMovie(mur);
		
		return movieService.getAllMovies();
	}
}
