package com.ssafy.member.model.service;

import com.ssafy.member.model.UserDto;
import com.ssafy.member.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean registerUser(UserDto user) {
        return userDao.registerUser(user) > 0;
    }

    @Override
    public boolean updateUser(UserDto user) {
        return userDao.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUser(String id) {
        return userDao.deleteUser(id) > 0;
    }

    @Override
    public UserDto loginUser(String id, String password) {
        return userDao.loginUser(id, password);
    }
}
