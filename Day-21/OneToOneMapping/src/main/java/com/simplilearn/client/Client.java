package com.simplilearn.client;

import com.simplilearn.beans.Address;
import com.simplilearn.beans.Employee;
import com.simplilearn.util.SessionFactoryManagerImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Client {

    public static void main(String[] args) {
        SessionFactory factory= new SessionFactoryManagerImpl().getSessionFactory();
        Session session= factory.openSession();
        Transaction transaction=session.beginTransaction();

        Employee employee=new Employee("Pradeep","Nilanjan");
        Address address=new Address("Street 1","454","S123123");

        int empId=(Integer) session.save(employee);
        int addId=(Integer) session.save(address);

        transaction.commit();
        session.close();

    }

}
