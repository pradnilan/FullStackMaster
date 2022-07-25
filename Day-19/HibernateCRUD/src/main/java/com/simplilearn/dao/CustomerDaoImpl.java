package com.simplilearn.dao;

import com.simplilearn.dto.Customer;
import com.simplilearn.util.SessionFactoryManager;
import com.simplilearn.util.SessionFactoryManagerImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory factory;

    public CustomerDaoImpl() {
        factory =new SessionFactoryManagerImpl().getSessionFactory();
    }

    @Override
    public Integer addCustomer(Customer customer) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        int custId=(Integer) session.save(customer);
        transaction.commit();
        session.close();
        return custId;
    }

    @Override
    public void updateCustomer(int custId, String address) {

        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        Customer customer=session.get(Customer.class,custId); // get method returns the object that hold the data for specified id
        customer.setAddress(address);
        session.update(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCustomer(int custId) {
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();
        Customer customer=session.get(Customer.class,custId); // get method returns the object that hold the data for specified id
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer searchCustomer(int custId) {
        Session session= factory.openSession();
        //Transaction transaction=session.beginTransaction();
        //Customer customer=session.get(Customer.class,custId); // get method returns the object that hold the data for specified id

        //using hql
        Customer customer=null;
        String  hql="from Customer c where c.custID="+custId;
        TypedQuery<Customer> typedQuery=session.createQuery(hql);
        customer=typedQuery.getSingleResult();

        session.close();
        return customer;
    }

    @Override
    public Set<Customer> getAllCustomer() {

        Set<Customer> allCustomer=null;

        Session session= factory.openSession();
        String hql="FROM Customer";//sql - select * from customerdata
        TypedQuery<Customer> typedQuery=session.createQuery(hql);
        List<Customer> customers=typedQuery.getResultList();
        allCustomer=new HashSet<Customer>(customers);
        session.close();
        return allCustomer;
    }

    @Override
    public List<String> getAllCustomerName() {

        Set<Customer> allCustomer=null;

        Session session= factory.openSession();
        String hql="select c.custName from Customer c ";//sql - select * from customerdata
        TypedQuery<String> typedQuery=session.createQuery(hql);
        List<String> customers=typedQuery.getResultList();
        session.close();
        return customers;
    }
}
