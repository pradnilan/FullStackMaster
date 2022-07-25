package com.simplilearn;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApacheConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumeFactory(){

        Map<String,Object> configProp=new HashMap<String,Object>();
        configProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProp.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProp.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        configProp.put(ConsumerConfig.GROUP_ID_CONFIG,"group-id");

        return new DefaultKafkaConsumerFactory<String,String>(configProp);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListener(){
        return  new ConcurrentKafkaListenerContainerFactory<String,String>();
    }

}
