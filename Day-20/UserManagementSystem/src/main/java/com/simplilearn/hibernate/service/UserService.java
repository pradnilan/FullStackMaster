package com.simplilearn.hibernate.service;

import com.simplilearn.hibernate.entity.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public void updateUser(int userId,String password);
    public void deleteUser(int userId);
    public User searchUser(int userId);
    public List<User> getAllUser();
}
