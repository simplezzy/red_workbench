package com.redcode.workbench.springbootrabbitmq.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderTopic {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.message",msg);
    }

    public void sendMessages(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages",msg);
    }

}
