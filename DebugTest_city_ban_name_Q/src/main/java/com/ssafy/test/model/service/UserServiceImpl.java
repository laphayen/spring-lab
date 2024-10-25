package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.dao.UserDao;
import com.ssafy.test.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	private static UserServiceImpl instance = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public User login(User user) throws SQLException {
		return userDao.login(user);
	}


	@Override
	public int register(User user) throws SQLException {
		return userDao.register(user);
	}
	
	@Override
	public User detail(String id) throws SQLException {
		return userDao.detail(id);
	}


	@Override
	public int update(User user) throws SQLException {
		return userDao.update(user);
	}



	
	
}
