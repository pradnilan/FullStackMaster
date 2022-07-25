package com.simplilearn.hibernate.dao;

import com.simplilearn.hibernate.entity.User;
import com.simplilearn.hibernate.util.SessionFactoryManagerImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactory factory;

    public UserDaoImpl() {
        factory=new SessionFactoryManagerImpl().getSessionFactory();
    }

    @Override
    public int addUser(User user) {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        int userId=(Integer) session.save(user);
        transaction.commit();
        session.close();
        return userId;
    }

    @Override
    public void updateUser(int userId, String password) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public User searchUser(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
