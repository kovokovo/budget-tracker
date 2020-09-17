package com.example.racun.configuration;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.listener.*;
import org.springframework.amqp.rabbit.listener.adapter.*;
import org.springframework.context.annotation.*;

@Configuration
public class ConfigureRabbitMq {

    public static final String topicExchangeName = "budget-tracker-exchange";

    static final String queueName = "budget-tracker";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ReceiveMessageHandler receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }




}
