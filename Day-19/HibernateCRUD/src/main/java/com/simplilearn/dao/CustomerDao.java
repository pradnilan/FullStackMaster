package com.simplilearn.dao;

import com.simplilearn.dto.Customer;


import java.util.List;
import java.util.Set;

public interface CustomerDao {

    public Integer addCustomer(Customer customer);
    public void updateCustomer(int custId,String address);
    public void deleteCustomer(int custId);
    public Customer searchCustomer(int custId);
    public Set<Customer> getAllCustomer();
    public List<String> getAllCustomerName();

}
