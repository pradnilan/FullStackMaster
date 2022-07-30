package com.example.microsvcapi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@ComponentScan({"com.example"})
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.entity")
public class MicrosvcApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicrosvcApi1Application.class, args);
    }

}
