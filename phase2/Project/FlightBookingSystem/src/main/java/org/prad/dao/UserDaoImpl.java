package org.prad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.entity.User;
import org.prad.entity.UserAccount;
import org.prad.util.SessionFactoryManagerImpl;

import javax.persistence.TypedQuery;

public class UserDaoImpl implements UserDao{

    private SessionFactory factory;
    private boolean isUserValid;

    public UserDaoImpl() {factory=new SessionFactoryManagerImpl().getSessionFactory();}

    @Override
    public Long addUserAccount(UserAccount user) {

        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        Long userId= (Long) session.save(user);
        transaction.commit();
        session.close();
        return userId ;
    }

    @Override
    public UserAccount findUser(String userName) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        UserAccount user;
        String hql="from UserAccount u where u.userName=:user_name";
        TypedQuery<UserAccount> typedQuery=session.createQuery(hql);
        typedQuery.setParameter("user_name",userName);
        user=typedQuery.getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public boolean validateUser(UserAccount user) {
        UserAccount userDB=findUser(user.getUserName());

        if(userDB!=null) {

            if (userDB.getPassword().equals(user.getPassword())) {
                isUserValid = true;
            } else {
                isUserValid = false;
            }
        } else isUserValid=false;
        return isUserValid;
    }

    @Override
    public String userType(UserAccount user) {
        UserAccount userDB=findUser(user.getUserName());
        return userDB.getProfile().getProfileType();
    }
}
