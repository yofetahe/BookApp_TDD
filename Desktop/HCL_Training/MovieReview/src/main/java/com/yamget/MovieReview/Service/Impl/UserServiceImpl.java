package com.yamget.MovieReview.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamget.MovieReview.Dao.UserDao;
import com.yamget.MovieReview.Model.User;
import com.yamget.MovieReview.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User getUserByEmail(User user) {
		
		return userDao.getUserByEmail(user);
	}

	public boolean insertUser(User user) {
		
		return userDao.insertUser(user);
	}

	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

}
