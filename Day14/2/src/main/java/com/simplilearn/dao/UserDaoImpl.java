package com.simplilearn.dao;

import com.simplilearn.model.User;
import com.simplilearn.util.Connection;

public class UserDaoImpl implements UserDao{

    Connection connection;

    public UserDaoImpl() {
        connection.getConnection();
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void registerUser(User user) {

    }
}
