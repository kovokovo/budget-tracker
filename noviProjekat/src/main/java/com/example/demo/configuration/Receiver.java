package com.example.demo.configuration;


import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class Receiver {
    public static final String topicExchangeName = "budget-tracker-exchange";
    @Autowired
RabbitTemplate rabbitTemplate;

    public void receiveMessage(String failMessage){

    }
}
