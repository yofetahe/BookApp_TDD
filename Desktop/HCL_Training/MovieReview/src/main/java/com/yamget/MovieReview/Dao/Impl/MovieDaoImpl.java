package com.yamget.MovieReview.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yamget.MovieReview.Dao.MoviesDao;
import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.MovieUserRel;

@Repository
public class MovieDaoImpl implements MoviesDao {

	@Autowired
	private SessionFactory sessionFactory;
	
//	public MovieDaoImpl(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public List<Movie> getAllMovies() {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Movie> query = sessionFactory.openSession().createQuery("FROM Movie");
		
	    List<Movie> result = query.getResultList();
	    
	    return result;		
	}
	

	public List<Movie> getAllMoviesByLoggedInUser(int user_id) {
		
		String hql = "SELECT a.movie_id, a.title, a.description, a.poster, a.genres, a.release_year, a.produced_by, a.cost, a.rate, a.participants, b.movieuser_id " + 
				"FROM Movie a LEFT JOIN (select movieuser_id, movie_id from MovieUserRel where user_id = :user_id) b ON a.movie_id = b.movie_id "
				+ "ORDER BY a.movie_id desc";
		
		@SuppressWarnings("unchecked")
		List<Object[]> query = sessionFactory.openSession().createNativeQuery(hql).setParameter("user_id", user_id).list();
		
	    List<Movie> result = new ArrayList<Movie>();
	    
	    for(Object[] x : query) {
	    	Movie m = new Movie();
	    	for(int i = 0; i < x.length; i++) {
	    		
	    		if(i == 0) { m.setMovie_id((Integer)x[i]); }
	    		else if(i == 1) { m.setTitle((String)x[i]); }
	    		else if(i == 2) { m.setDescription((String)x[i]); }
	    		else if(i == 3) { m.setPoster((String)x[i]); }
	    		else if(i == 4) { m.setGenres((String)x[i]); }
	    		else if(i == 5) { m.setRelease_year((Integer)x[i]); }
	    		else if(i == 6) { m.setProduced_by((String)x[i]); }
	    		else if(i == 7) { m.setCost((Double)x[i]); }
	    		else if(i == 8) { m.setRate((Double)x[i]); }
	    		else if(i == 9) { m.setParticipants((String)x[i]); }
	    		else if(i == 10) {
	    			String y = "" + x[i];	    			
	    			if(y.equals("null")) 
	    				m.setMovieuser_id(0);
	    			else
	    				m.setMovieuser_id((Integer)x[i]); 
	    		}	    		
	    	}	    	
	    	result.add(m);
	    }
	    
	    return result;
	}
	
	public List<Movie> getMyMovies(int user_id) {
		
		String hql = "SELECT a.movie_id, a.title, a.description, a.poster, a.genres, a.release_year, a.produced_by, a.cost, a.rate, a.participants, b.movieuser_id " + 
				"FROM Movie a, MovieUserRel b " + 
				"WHERE a.movie_id = b.movie_id and b.user_id = :user_id";
		
		@SuppressWarnings("unchecked")
		List<Object[]> query = sessionFactory.openSession().createNativeQuery(hql).setParameter("user_id", user_id).list();
		
	    List<Movie> result = new ArrayList<Movie>();
	    
	    for(Object[] x : query) {
	    	Movie m = new Movie();
	    	for(int i = 0; i < x.length; i++) {
	    		
	    		if(i == 0) { m.setMovie_id((Integer)x[i]); }
	    		else if(i == 1) { m.setTitle((String)x[i]); }
	    		else if(i == 2) { m.setDescription((String)x[i]); }
	    		else if(i == 3) { m.setPoster((String)x[i]); }
	    		else if(i == 4) { m.setGenres((String)x[i]); }
	    		else if(i == 5) { m.setRelease_year((Integer)x[i]); }
	    		else if(i == 6) { m.setProduced_by((String)x[i]); }
	    		else if(i == 7) { m.setCost((Double)x[i]); }
	    		else if(i == 8) { m.setRate((Double)x[i]); }
	    		else if(i == 9) { m.setParticipants((String)x[i]); }
	    		else if(i == 10) { m.setMovieuser_id((Integer)x[i]); }	    		
	    	}	    	
	    	result.add(m);
	    }
	    
	    return result;
	}

	public Movie getMovieById(int movie_id) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Movie> query = sessionFactory.openSession().createQuery("FROM Movie WHERE movie_id = " + movie_id);
		
		List<Movie> result = query.getResultList();
		
		if(result.size() == 0) {
		
			return null;
			
		} else {
			
			return result.get(0);
		}
	}

	public boolean insertMovie(Movie movie) {

		String hql = "INSERT INTO Movie(title, description, poster, genres, release_year, produced_by, cost, rate, participants, create_by) "
				+ "VALUES(:title, :description, :poster, :genres, :release_year, :produced_by, :cost, :rate, :participants, 1)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("title", movie.getTitle());
		query.setParameter("description", movie.getDescription());
		query.setParameter("poster", movie.getPoster());		
		query.setParameter("genres", movie.getGenres());		
		query.setParameter("release_year", movie.getRelease_year());
		query.setParameter("produced_by", movie.getProduced_by());
		query.setParameter("cost", movie.getCost());		
		query.setParameter("rate", 0);
		query.setParameter("participants", movie.getParticipants());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return true;
		} else {
			return false;
		}
	}

	public boolean updateMovie(Movie movie) {
		
		String hql = "UPDATE Movie "
				+ "SET title = :title, description = :description, poster = :poster, genres = :genres, "
					+ "release_year = :release_year, produced_by = :produced_by, cost = :cost, participants = :participants "
				+ "WHERE movie_id = :movie_id";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("title", movie.getTitle());
		query.setParameter("description", movie.getDescription());
		query.setParameter("poster", movie.getPoster());		
		query.setParameter("genres", movie.getGenres());		
		query.setParameter("release_year", movie.getRelease_year());
		query.setParameter("produced_by", movie.getProduced_by());
		query.setParameter("cost", movie.getCost());
		query.setParameter("participants", movie.getParticipants());		
		query.setParameter("movie_id", movie.getMovie_id());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return true;
		} else {
			return false;
		}
	}

	public List<MovieComment> getCommentsByMovieId(int movie_id) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<MovieComment> query = sessionFactory.openSession().createQuery("FROM MovieComment WHERE movie_id = " + movie_id);
		
	    List<MovieComment> result = query.getResultList();
	    
	    return result;	
	}
	
	public MovieComment getCommentsById(int comment_id) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<MovieComment> query = sessionFactory.openSession().createQuery("FROM MovieComment WHERE comment_id = " + comment_id);
		
	    List<MovieComment> result = query.getResultList();
	    
	    if(result.size() == 0) {
			
			return null;
			
		} else {
			
			return result.get(0);
		}	
	}

	public boolean addMovieComment(MovieComment comment) {
		
		String hql = "INSERT INTO MovieComment(content, given_by, movie_id, like_count, dislike_count) "
				+ "VALUES(:content, :given_by, :movie_id, 0, 0)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("content", comment.getContent());
		query.setParameter("given_by", comment.getGiven_by());
		query.setParameter("movie_id", comment.getMovie_id());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public MovieComment insertMovieComment(MovieComment comment) {
		
		String hql = "INSERT INTO MovieComment(content, given_by, movie_id, like_count, dislike_count) "
				+ "VALUES(:content, :given_by, :movie_id, 0, 0)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("content", comment.getContent());
		query.setParameter("given_by", comment.getGiven_by());
		query.setParameter("movie_id", comment.getMovie_id());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return getCommentsById(rslt);
		} else {
			return null;
		}
	}

	public Movie addMovie(Movie movie) {
		
		String hql = "INSERT INTO Movie(title, description, poster, genres, release_year, produced_by, cost, rate, participants, create_by) "
				+ "VALUES(:title, :description, :poster, :genres, :release_year, :produced_by, :cost, :rate, :participants, 1)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("title", movie.getTitle());
		query.setParameter("description", movie.getDescription());
		query.setParameter("poster", movie.getPoster());		
		query.setParameter("genres", movie.getGenres());		
		query.setParameter("release_year", movie.getRelease_year());
		query.setParameter("produced_by", movie.getProduced_by());
		query.setParameter("cost", movie.getCost());		
		query.setParameter("rate", 0);
		query.setParameter("participants", movie.getParticipants());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return getMovieById(rslt);
		} else {
			return null;
		}
	}

	public boolean addMovieCommentLike(int comment_id) {
		
		MovieComment commentList = getCommentsById(comment_id);
		int likeCount = commentList.getLike_count() + 1;
		
		String hql = "UPDATE MovieComment SET like_count = :like_count "
				+ "WHERE comment_id = :comment_id";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("like_count", likeCount);				
		query.setParameter("comment_id", comment_id);
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		return true;
	}
	
	public boolean addMovieCommentDislike(int comment_id) {
		
		MovieComment commentList = getCommentsById(comment_id);
		int dislikeCount = commentList.getDislike_count() + 1;
		
		String hql = "UPDATE MovieComment SET dislike_count = :dislike_count "
				+ "WHERE comment_id = :comment_id";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("dislike_count", dislikeCount);				
		query.setParameter("comment_id", comment_id);
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		return true;
	}

	public boolean addWatchedMovie(MovieUserRel mur) {
		
		String hql = "INSERT INTO MovieUserRel(movie_id, user_id) "
				+ "VALUES(:movie_id, :user_id)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("movie_id", mur.getMovie_id());
		query.setParameter("user_id", mur.getUser_id());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return true;
		} else {
			return false;
		}
	}
}
