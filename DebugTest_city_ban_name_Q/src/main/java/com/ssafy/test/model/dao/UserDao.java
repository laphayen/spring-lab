package com.ssafy.test.model.dao;

import java.sql.SQLException;

import com.ssafy.test.dto.User;

public interface UserDao {

	User login(User user) throws SQLException;
	int register(User user) throws SQLException;
	User detail(String id) throws SQLException;
	int update(User user) throws SQLException;
	
}
