package com.simplilearn.hibernate.client;

import com.simplilearn.hibernate.entity.User;
import com.simplilearn.hibernate.util.SessionFactoryManagerImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Client {

    public static void main(String[] args) {

        SessionFactory factory=new SessionFactoryManagerImpl().getSessionFactory();

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        User user=new User("prad","Nil","prad","123");
        int userId=(Integer) session.save(user);
        transaction.commit();
        session.close();
    }
}
