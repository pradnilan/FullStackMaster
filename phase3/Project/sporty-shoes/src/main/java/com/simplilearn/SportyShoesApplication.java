package com.simplilearn;

import com.simplilearn.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@SpringBootApplication
@ComponentScan("com.simplilearn")
@EnableJpaRepositories("com.simplilearn.repository")
@EntityScan("com.simplilearn")
public class SportyShoesApplication {



    public static void main(String[] args) {SpringApplication.run(SportyShoesApplication.class, args);}

}
