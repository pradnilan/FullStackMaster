package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }

}
