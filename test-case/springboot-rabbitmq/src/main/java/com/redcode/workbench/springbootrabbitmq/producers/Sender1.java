package com.redcode.workbench.springbootrabbitmq.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
        this.rabbitTemplate.convertAndSend("hello",msg);
    }
}
