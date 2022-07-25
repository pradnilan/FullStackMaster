package org.prad.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.prad.entity.Airport;
import org.prad.util.SessionFactoryManagerImpl;

import javax.persistence.TypedQuery;
import java.util.List;

public class AirportDaoImpl implements AirportDao{

    private SessionFactory factory;

    public AirportDaoImpl() {factory=new SessionFactoryManagerImpl().getSessionFactory();
    }

    @Override
    public List<Airport> searchAllAirport() {
        Session session= factory.openSession();

        List<Airport> airports;

        String hql="From Airport";
        TypedQuery<Airport> typedQuery=session.createQuery(hql);
        airports=typedQuery.getResultList();
        session.close();

        return airports;
    }
}
