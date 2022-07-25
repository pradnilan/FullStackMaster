package com.simplilearn.trg.jdbc.client;

import com.simplilearn.trg.jdbc.dto.Employee;
import com.simplilearn.trg.jdbc.service.EmployeeService;
import com.simplilearn.trg.jdbc.service.EmployeeServiceImpl;
import com.simplilearn.trg.jdbc.util.ConnectionManager;
import com.simplilearn.trg.jdbc.util.ConnectionManagerImpl;

public class Client {
    public static void main(String[] args) {

        Employee emp=new Employee(1010,"Amith","Developer");

        EmployeeService employeeService=new EmployeeServiceImpl();
        boolean isEmployeeAdded = employeeService.addEmployee(emp);

        if (isEmployeeAdded) System.out.println("Employee added successfully");
        else System.out.println("Employee not added");



    }


}
