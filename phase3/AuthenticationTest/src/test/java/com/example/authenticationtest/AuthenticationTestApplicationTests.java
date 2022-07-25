package com.example.authenticationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AuthenticationTestApplication.class})
class AuthenticationTestApplicationTests {

    @Autowired
    UserDao dao;

    @Test
    void contextLoads() {
    }

    @Test
    void addUser(){
        assertEquals(1,dao.addUser(new User(1,"prad","prad@gmail.com","123")));
    }

    @Test
    void authenticationWithInvalidData(){
        assertFalse(dao.getUser(null,null));
    }

    @Test
    void authenticateWithValidData(){
        assertTrue(dao.getUser("prad@gmail.com","123"));
    }

}
