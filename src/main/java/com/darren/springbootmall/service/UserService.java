package com.darren.springbootmall.service;

import com.darren.springbootmall.dto.UserRegisterRequest;
import com.darren.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);


}
