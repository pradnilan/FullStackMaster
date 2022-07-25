package org.prad.service;

import org.prad.dao.UserDao;
import org.prad.dao.UserDaoImpl;
import org.prad.entity.User;
import org.prad.entity.UserAccount;

public class UserServiceImpl implements UserService{

    UserDao userDao;

    public UserServiceImpl() {
        userDao=new UserDaoImpl();
    }

    @Override
    public Long addUserAccount(UserAccount user) {
        return userDao.addUserAccount(user);
    }

    @Override
    public UserAccount findUser(String userName) {
        return userDao.findUser(userName);
    }

    @Override
    public boolean validateUser(UserAccount user) {
        return userDao.validateUser(user);
    }

    @Override
    public String userType(UserAccount user) {
        return userDao.userType(user);
    }
}
