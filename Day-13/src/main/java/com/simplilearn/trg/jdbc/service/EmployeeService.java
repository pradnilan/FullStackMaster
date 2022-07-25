package com.simplilearn.trg.jdbc.service;

import com.simplilearn.trg.jdbc.dto.Employee;

public interface EmployeeService {

    public boolean addEmployee(Employee employee);
    public boolean searchEmployeebyId(int empId);
    public String[] searchEmployeebyName(String name);

}
