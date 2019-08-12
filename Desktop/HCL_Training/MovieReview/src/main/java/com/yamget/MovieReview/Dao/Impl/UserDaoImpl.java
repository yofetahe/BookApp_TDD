package com.yamget.MovieReview.Dao.Impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yamget.MovieReview.Dao.UserDao;
import com.yamget.MovieReview.Model.Movie;
import com.yamget.MovieReview.Model.MovieComment;
import com.yamget.MovieReview.Model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public User getUserByEmail(User user) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.openSession().createQuery("FROM User WHERE email = :email");
		query.setParameter("email", user.getEmail());
		List<User> u = query.getResultList();
				
		for (User us : u) {
			return us;
		}			
		
		return null;
	}
	
	public User getUserById(int id) {
		
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.openSession().createQuery("FROM User WHERE user_id = :user_id");
		query.setParameter("user_id", id);
		List<User> u = query.getResultList();
				
		for (User us : u) {
			return us;
		}			
		
		return null;
	}

	public boolean insertUser(User user) {
		
		String hql = "INSERT INTO User(full_name, email, password) "
				+ "VALUES(:full_name, :email, :password)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("full_name", user.getFull_name());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return true;
		} else {
			return false;
		}
	}

	public User addUser(User user) {
		
		String hql = "INSERT INTO User(full_name, email, password) "
				+ "VALUES(:full_name, :email, :password)";
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createNativeQuery(hql);
		query.setParameter("full_name", user.getFull_name());
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		int rslt = query.executeUpdate();
		
		transaction.commit();
		
		if(rslt > 0){
			return getUserById(rslt);
		} else {
			return null;
		}
	}

}
