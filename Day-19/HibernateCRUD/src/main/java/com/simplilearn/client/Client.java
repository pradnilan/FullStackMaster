package com.simplilearn.client;

import com.simplilearn.dto.Customer;
import com.simplilearn.service.CustomerService;
import com.simplilearn.service.CustomerServiceImpl;
import com.simplilearn.util.SessionFactoryManagerImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Client {

    public static void main(String[] args) {

        SessionFactory factory=new SessionFactoryManagerImpl().getSessionFactory();


        CustomerService customerService=new CustomerServiceImpl();
//        Customer customer1=new Customer("Seeta","Colombo");
//        Customer customer2=new Customer("Geeta","Kandy");
//        Customer customer3=new Customer("Neeta","Galle");
//        Customer customer4=new Customer("Radha","Jaffna");
//        Integer cusdtId=customerService.addCustomer(customer1);
//        cusdtId=customerService.addCustomer(customer2);
//        cusdtId=customerService.addCustomer(customer3);
//        cusdtId=customerService.addCustomer(customer4);
//        System.out.println("Customer Added"+cusdtId);


       //customerService.updateCustomer(4,"KKS");
       // customerService.deleteCustomer(3);
       // Customer customer5=customerService.searchCustomer(1);
        //System.out.println("Result is: "+customer5);

//        System.out.println(customerService.getAllCustomer());
//        System.out.println(customerService.getAllCustomerName());

    }
}
