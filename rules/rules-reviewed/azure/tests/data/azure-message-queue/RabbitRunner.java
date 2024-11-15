package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.messagingrabbitmq.MessagingRabbitmqApplication.routingKey;

@Component
public class RabbitRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Sending message..."+i);
            rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, routingKey, "Hello from RabbitMQ!"+i);
        }
    }

}
