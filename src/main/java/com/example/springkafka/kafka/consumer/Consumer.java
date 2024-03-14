package com.example.springkafka.kafka.consumer;

import com.example.springkafka.domain.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "springtopic")
    public void onMessage(ConsumerRecord<String, String> message) throws JsonProcessingException {
        String customerJson = message.value();
        Customer customer = objectMapper.readValue(customerJson, Customer.class);
        System.out.println(customer);
    }

}
