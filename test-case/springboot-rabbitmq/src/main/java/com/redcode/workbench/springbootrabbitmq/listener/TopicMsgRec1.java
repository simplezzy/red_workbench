package com.redcode.workbench.springbootrabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicMsgRec1 {

    @RabbitListener(queues = "topic.message")
    public void onMessage(String msg) {
        System.out.println("topicMessageReceiver1: " + msg);
    }
}
