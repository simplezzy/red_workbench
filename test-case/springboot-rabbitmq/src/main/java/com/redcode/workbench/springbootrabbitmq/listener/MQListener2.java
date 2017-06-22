package com.redcode.workbench.springbootrabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQListener2 {

    @RabbitListener(queues = "hello")
    public void onMessage(@Payload String text) {
        System.out.println("Receiver2:" + text);
    }
}
