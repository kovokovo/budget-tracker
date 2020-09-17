package com.example.demo;

import io.swagger.annotations.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;
@RestController
public class TransactionRabbitController {

    public static final String topicExchangeName = "budget-tracker-exchange";

@Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/transaction/add/{racunId}")
    String addMoney(@PathVariable Long racunId,@RequestBody BigDecimal iznos){

        rabbitTemplate.convertAndSend(topicExchangeName,
                "routing", racunId + "." + iznos);

        return "Sent a message! :" + racunId + "." + iznos;
    }

    @PostMapping("/transaction/take/{racunId}")
    String takeMoney(@PathVariable Long racunId,@RequestBody BigDecimal iznos){

        rabbitTemplate.convertAndSend(topicExchangeName,
                "routing", racunId + "-" + iznos);

        return "Sent a message! :" + racunId + "-" + iznos;
    }
}
