package com.simplilearn.dataccess;

import com.simplilearn.model.Employee;

import java.util.Set;

public interface EmployeeDao {

    boolean addEmployee(Employee  employee);
    boolean deleteEmployee(Employee employee);
    Set<Employee> getAllEmployee();
}
