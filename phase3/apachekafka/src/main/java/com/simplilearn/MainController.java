package com.simplilearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/send")
    public String sendMessage(){
       kafkaTemplate.send("GENERAL","Hellow from Apache Kafka");
        return "Message sent successfuly, check the console to read the message";
    }

}
