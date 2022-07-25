package com.simplilearn.trg.jdbc.dao;

import com.simplilearn.trg.jdbc.dto.Employee;
import com.simplilearn.trg.jdbc.util.ConnectionManager;
import com.simplilearn.trg.jdbc.util.ConnectionManagerImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements  EmployeeDao{

    Connection connection;

    public EmployeeDaoImpl() {

        connection=new ConnectionManagerImpl().getConnection();

    }

    @Override
    public boolean addEmployee(Employee employee) {

        String sql="insert into emp values(?,?,?)";
        boolean isEmployeeAdded=false;

        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,employee.getEmpID());
            ps.setString(2,employee.getEmpName());
            ps.setString(3,employee.getEmpDesignation());
            var val=ps.executeUpdate();
            if(val>0) isEmployeeAdded=true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return isEmployeeAdded;
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
