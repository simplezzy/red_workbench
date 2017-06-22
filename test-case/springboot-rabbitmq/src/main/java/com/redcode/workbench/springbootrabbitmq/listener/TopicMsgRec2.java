package com.redcode.workbench.springbootrabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicMsgRec2 {

    @RabbitListener(queues = "topic.messages")
    public void onMessage(String msg) {
        System.out.println("topicMessageReceiver2: " +msg);
    }
}
