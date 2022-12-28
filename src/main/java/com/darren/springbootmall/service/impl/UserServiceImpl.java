package com.darren.springbootmall.service.impl;

import com.darren.springbootmall.dao.UserDao;
import com.darren.springbootmall.dto.UserRegisterRequest;
import com.darren.springbootmall.model.User;
import com.darren.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
