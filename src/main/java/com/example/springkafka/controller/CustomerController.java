package com.example.springkafka.controller;

import com.example.springkafka.kafka.producer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    Producer producer;

    @GetMapping("/send")
    public void sendMessage() throws JsonProcessingException {
        producer.sendCustomer();
    }
}
