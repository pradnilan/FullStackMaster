package com.simplilearn.util;

import java.sql.DriverManager;

public class ConnectionImpl implements Connection{
    @Override
    public Connection getConnection() {

        Class.forName();
        Connection connection= DriverManager.getConnection();

    }
}
