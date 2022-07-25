package com.example.restfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example")

@SpringBootApplication
@ComponentScan({"com.example"})
@EnableJpaRepositories("com.example.repo")
public class RestfulserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulserviceApplication.class, args);
    }

}
