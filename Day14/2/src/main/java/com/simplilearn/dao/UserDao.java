package com.simplilearn.dao;

import com.simplilearn.model.User;

public interface UserDao {

    public User getUser(String username);
    public void registerUser(User user);

}
