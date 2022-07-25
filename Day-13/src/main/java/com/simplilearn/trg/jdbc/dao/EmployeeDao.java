package com.simplilearn.trg.jdbc.dao;

import com.simplilearn.trg.jdbc.dto.Employee;

public interface EmployeeDao {

    public boolean addEmployee(Employee employee);
    public boolean searchEmployeebyId(int empId);
    public String[] searchEmployeebyName(String name);

}
