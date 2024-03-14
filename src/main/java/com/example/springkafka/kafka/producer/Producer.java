package com.example.springkafka.kafka.producer;

import com.example.springkafka.domain.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public  void sendCustomer() throws JsonProcessingException {
        Customer customer = new Customer(1L, "Laura", 25.5);
        String json = objectMapper.writeValueAsString(customer);
        kafkaTemplate.sendDefault(json);
        //kafkaTemplate.send("anothertopic", json);
    }

}
