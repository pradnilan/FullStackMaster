package com.example.authenticationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate template;

    public int addUser(User user){
        return template.update("INSERT INTO users (id,name,email,password)" +
                "VALUES (?,?,?,?)",user.getId(),user.getName(),user.getEmail(),user.getPassword());
    }

    public boolean getUser(String email, String password) {
        return template.query("select * from users where email=" + "'"+email+"'", new ResultSetExtractor<Boolean>() {
            @Override
            public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    User user=new User();
                    user.setId(rs.getInt(1));
                    user.setName(rs.getString(2));
                    user.setEmail(rs.getString(3));
                    user.setPassword(rs.getString(4));

                    if(user.getEmail().equals(email) & user.getPassword().equals(password)) return true;
                    else return false;

                }
                return false;
            }
        });
    }
}
