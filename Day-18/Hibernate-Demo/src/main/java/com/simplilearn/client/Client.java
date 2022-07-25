package com.simplilearn.client;

import com.simplilearn.hibernate.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Client {

    public static void main(String[] args) {

        //read configuration file & establish the connection with the database
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();

        //create an object which needs to be persisted
        Student student1=new Student("Ramlal","verma","A+");

        //create an object of session to add the object in database table
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println(student1);
        int rollNo= (int)session.save(student1);
        transaction.commit(); //if not committed, the changes will not be reflected in databse

        System.out.println("Roll no is: "+rollNo);
        factory.close();
    }
}
