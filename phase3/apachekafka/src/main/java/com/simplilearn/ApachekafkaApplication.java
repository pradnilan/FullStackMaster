package com.simplilearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@ComponentScan("com.simplilearn")
@EnableKafka
public class ApachekafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApachekafkaApplication.class, args);
    }

    @KafkaListener(topics = "GENERAL",groupId = "group-id")
    public void listen(String msg){

        System.out.println("Message Received: "+msg);

    }

}
