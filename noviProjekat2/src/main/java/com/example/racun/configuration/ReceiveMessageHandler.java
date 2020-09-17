package com.example.racun.configuration;


import com.example.racun.*;
import com.example.racun.dao.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class ReceiveMessageHandler {
    public static final String topicExchangeName = "budget-tracker-exchange";
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Racuni racuni;

    public void receiveMessage(String message) {
        log.info("HandleMessage!!!");

        try {
            Racun racun = racuni.findById(Long.valueOf(message.substring(0,message.indexOf(".")))).get();
            racun.setTrenutnoStanje(racun.getTrenutnoStanje()+Long.valueOf(message.substring(message.indexOf(".")+1,message.length())));
          racuni.save(racun);
        } catch (Exception e) {
            Racun racun = racuni.findById(Long.valueOf(message.substring(0,message.indexOf("-")))).get();
            racun.setTrenutnoStanje(racun.getTrenutnoStanje()-Long.valueOf(message.substring(message.indexOf("-")+1,message.length())));
            racuni.save(racun);
        }
    }

}
