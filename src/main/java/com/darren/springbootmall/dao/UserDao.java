package com.darren.springbootmall.dao;

import com.darren.springbootmall.dto.UserRegisterRequest;
import com.darren.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);

}
