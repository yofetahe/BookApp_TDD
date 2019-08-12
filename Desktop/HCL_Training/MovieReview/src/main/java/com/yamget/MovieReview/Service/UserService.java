package com.yamget.MovieReview.Service;

import com.yamget.MovieReview.Model.User;

public interface UserService {

	public User getUserByEmail(User user);
	
	public boolean insertUser(User user);
	
	public User addUser(User user);
}
