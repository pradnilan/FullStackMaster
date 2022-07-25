package com.simplilearn.hibernate.service;

import com.simplilearn.hibernate.dao.UserDao;
import com.simplilearn.hibernate.dao.UserDaoImpl;
import com.simplilearn.hibernate.entity.User;
import lombok.NoArgsConstructor;

import java.util.List;


public class UserServiceImpl implements UserService{

    private UserDao dao;

    public UserServiceImpl() {
        dao=new UserDaoImpl();
    }

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public void updateUser(int userId, String password) {
        dao.updateUser(userId,password);
    }

    @Override
    public void deleteUser(int userId) {
        dao.deleteUser(userId);
    }

    @Override
    public User searchUser(int userId) {
        return dao.searchUser(userId);
    }

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }
}
