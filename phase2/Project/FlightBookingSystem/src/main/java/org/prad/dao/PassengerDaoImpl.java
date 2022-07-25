package org.prad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.entity.Passenger;
import org.prad.entity.UserAccount;
import org.prad.util.SessionFactoryManagerImpl;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoImpl implements PassengerDao{

    SessionFactory factory;

    public PassengerDaoImpl() {
        factory=new SessionFactoryManagerImpl().getSessionFactory();
    }

    @Override
    public List<Long> addPassengers(List<Passenger> passengers) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<Long> userId=new ArrayList<>();

        for (Passenger passenger:passengers) {
            Long id= (Long) session.save(passenger);
            userId.add(id);
        }
        transaction.commit();
        session.close();
        return userId;
    }
}
