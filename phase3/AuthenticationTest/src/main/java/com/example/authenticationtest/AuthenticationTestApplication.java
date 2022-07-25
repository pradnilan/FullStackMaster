package com.example.authenticationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class AuthenticationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationTestApplication.class, args);
    }

}
