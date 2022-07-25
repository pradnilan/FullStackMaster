package com.simplilearn.service;

import com.simplilearn.dataccess.EmployeeDao;
import com.simplilearn.dataccess.EmployeeDaoImpl;
import com.simplilearn.model.Employee;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao=new EmployeeDaoImpl();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public Set<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
