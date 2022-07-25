package com.simplilearn.consumingwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.simplilearn.consumingwebservice")
public class ConsumingwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingwebserviceApplication.class, args);
    }

}
