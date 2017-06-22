package com.redcode.workbench.springbootrabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class MQListener1 {

    @RabbitHandler
    public void onMessage(@Payload String hello) {
        System.out.println("Receiver1:" + hello);
    }

}
