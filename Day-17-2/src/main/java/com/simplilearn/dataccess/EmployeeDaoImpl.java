package com.simplilearn.dataccess;

import com.simplilearn.model.Employee;
import com.simplilearn.util.ConnectionManager;
import com.simplilearn.util.ConnectionManagerImpl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDaoImpl implements EmployeeDao{

    private Connection connection;

    public EmployeeDaoImpl() {
        connection=new ConnectionManagerImpl().getConnection();
    }

    @Override
    public boolean addEmployee(Employee employee) {

        //String sql="insert into emp"

        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public Set<Employee> getAllEmployee() {
        Set<Employee> allEmps=new HashSet<Employee>();
        String query="select * from emp";

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                Employee employee=new Employee(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getString(3));
                allEmps.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allEmps;
    }
}
