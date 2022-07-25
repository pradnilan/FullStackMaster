package com.simplilearn.trg.jdbc.service;

import com.simplilearn.trg.jdbc.dao.EmployeeDao;
import com.simplilearn.trg.jdbc.dao.EmployeeDaoImpl;
import com.simplilearn.trg.jdbc.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao=new EmployeeDaoImpl();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean searchEmployeebyId(int empId) {
        return false;
    }

    @Override
    public String[] searchEmployeebyName(String name) {
        return new String[0];
    }
}
