package com.simplilearn.hibernate.dao;

import com.simplilearn.hibernate.entity.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public void updateUser(int userId, String password);
    public void deleteUser(int userId);
    public User searchUser(int userId);
    public List<User> getAllUser();
}
