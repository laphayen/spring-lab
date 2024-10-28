package com.ssafy.member.model.dao;

import com.ssafy.member.model.UserDto;

public interface UserDao {
    UserDto getUserById(String id);
    int registerUser(UserDto user);
    int updateUser(UserDto user);
    int deleteUser(String id);
    UserDto loginUser(String id, String password);
}
