package com.ssafy.member.model.service;

import com.ssafy.member.model.UserDto;

public interface UserService {
    UserDto getUserById(String id);
    boolean registerUser(UserDto user);
    boolean updateUser(UserDto user);
    boolean deleteUser(String id);
    UserDto loginUser(String id, String password);
}
