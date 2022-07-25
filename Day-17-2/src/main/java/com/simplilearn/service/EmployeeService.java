package com.simplilearn.service;

import com.simplilearn.model.Employee;

import java.util.Set;

public interface EmployeeService {

    boolean addEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    Set<Employee> getAllEmployee();

}
