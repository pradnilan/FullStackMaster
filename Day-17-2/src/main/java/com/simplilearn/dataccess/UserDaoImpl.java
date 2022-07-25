package com.simplilearn.dataccess;

import com.simplilearn.model.User;
import com.simplilearn.util.ConnectionManagerImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao{
    @Override
    public boolean validateUser(User user) {

        boolean isUserValid=false;

        Connection connection= new ConnectionManagerImpl().getConnection();

        String sql="select * from userdetails where username='"+user.getUserName()+"' and pasword='"+user.getPassword()+"'";

        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            System.out.println(resultSet);
            if(resultSet.next())
                isUserValid=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return isUserValid;
    }
}
