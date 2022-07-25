package com.simplilearn.service;

import com.simplilearn.dataccess.UserDao;
import com.simplilearn.dataccess.UserDaoImpl;
import com.simplilearn.model.User;

public class UserServiceImpl implements UserService{

    UserDao user;

    @Override
    public boolean validateUser(User user) {

        return new UserDaoImpl().validateUser(user);
    }
}
