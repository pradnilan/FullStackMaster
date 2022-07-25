package com.simplilearn.service;

import com.simplilearn.dao.CustomerDao;
import com.simplilearn.dao.CustomerDaoImpl;
import com.simplilearn.dto.Customer;

import java.util.List;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService{

    CustomerDao customerDao;

    public CustomerServiceImpl() {

        customerDao=new CustomerDaoImpl();
    }

    @Override
    public Integer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer) ;
    }

    @Override
    public void updateCustomer(int custId, String address) {
        customerDao.updateCustomer(custId,address);
    }

    @Override
    public void deleteCustomer(int custId) {
        customerDao.deleteCustomer(custId);
    }

    @Override
    public Customer searchCustomer(int custId) {
        return customerDao.searchCustomer(custId);
    }

    @Override
    public Set<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public List<String> getAllCustomerName() {
        return customerDao.getAllCustomerName();
    }
}
