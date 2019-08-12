package com.yamget.MovieReview.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.User;
import com.yamget.MovieReview.Service.MovieService;
import com.yamget.MovieReview.Service.UserService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getMovies() {
		
		List<Movie> movies = movieService.getAllMovies();
		
		ModelAndView model = new ModelAndView("index");
		
		model.addObject("movies", movies);
		
		return model;
	}
	
	@RequestMapping(value="/comment/{id}", method=RequestMethod.GET)
	public ModelAndView getMovieById(@PathVariable("id") int id) {
		
		Movie movie = movieService.getMovieById(id);
		
		List<MovieComment> comments = movieService.getCommentsByMovieId(id);
		
		ModelAndView model = new ModelAndView("comment");
		
		MovieComment commentForm = new MovieComment();
		model.addObject("commentForm", commentForm);
		
		model.addObject("movie", movie);
		model.addObject("comments", comments);
		
		return model;
	}
	
	@RequestMapping(value="/add_comment/{id}", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("MovieComment") MovieComment comment, @PathVariable("id") int id) {
		
		comment.setMovie_id(id);
		
		boolean result = movieService.addMovieComment(comment);
		
		return "redirect:comment/"+id;
	}
	
	@RequestMapping(value="/movie_add_form", method=RequestMethod.GET)
	public ModelAndView getMovieAddFrom() {
		
		ModelAndView model = new ModelAndView("movie_add_form");
		
		Movie movieForm = new Movie();
		model.addObject("movieForm", movieForm);
		
		return model;
	}
	
	@RequestMapping(value="/add_movie", method=RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute("movieForm")Movie movie, BindingResult result, Errors error) {
		
		boolean check = movieService.insertMovie(movie);
		
		if(check) {
		
			List<Movie> movies = movieService.getAllMovies();
			
			ModelAndView model = new ModelAndView("index");
			
			model.addObject("movies", movies);
			
			return model;
			
		} else {
			
			ModelAndView model = new ModelAndView("movie_add_form");
			
			return model;
		}
	}
	
	@RequestMapping(value="/sign_up", method=RequestMethod.GET)
	public ModelAndView getSignUpForm() {
		
		ModelAndView model = new ModelAndView("sign_up");
		
		User user = new User();
		model.addObject("user", user);
		
		return model;
	}
	
	@RequestMapping(value="/add_user", method=RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("userForm")User user, BindingResult result, Errors error) {
		
		User u = userService.getUserByEmail(user);
		
		if(error.hasErrors() || !user.getPassword().equals(user.getConfirm_password()) || u != null) {
			ModelAndView model = new ModelAndView("sign_up");
			User us = new User();
			model.addObject("user", us);
			return model;
		}
				
		//Password encryption
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		boolean check = userService.insertUser(user);
		
		if(check) {
		
			List<Movie> movies = movieService.getAllMovies();
			
			ModelAndView model = new ModelAndView("index");
			
			model.addObject("movies", movies);
			
			return model;
			
		} else {
			
			ModelAndView model = new ModelAndView("sign_up");
			
			User us = new User();
			model.addObject("user", us);
			
			return model;
		}
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView getLoginForm() {
//		
//		ModelAndView model = new ModelAndView("login");
//		
//		User user = new User();
//		model.addObject("user", user);
//		
//		return model;
//	}
//	
//	@RequestMapping(value="/Authenticate", method=RequestMethod.POST)
//	public ModelAndView login(@ModelAttribute("userForm")User user, BindingResult result, Errors error) {
//		
//		User u = userService.getUserByEmail(user);
//		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		encoder.matches(user.getPassword(), u.getPassword());
//		
//		boolean check = encoder.matches(user.getPassword(), u.getPassword());
//		
//		if(check) {
//		
//			List<Movie> movies = movieService.getAllMovies();
//			
//			ModelAndView model = new ModelAndView("index");
//			
//			model.addObject("movies", movies);
//			
//			return model;
//			
//		} else {
//			
//			ModelAndView model = new ModelAndView("login");
//			
//			User us = new User();
//			model.addObject("user", us);
//			
//			return model;
//		}
//	}
}
