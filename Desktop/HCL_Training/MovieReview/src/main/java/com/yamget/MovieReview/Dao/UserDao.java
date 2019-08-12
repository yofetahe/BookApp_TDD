package com.yamget.MovieReview.Dao;

import com.yamget.MovieReview.Model.User;

public interface UserDao {

	public User getUserByEmail(User user);
	
	public boolean insertUser(User user);
	
	public User addUser(User user);
}
