package com.redcode.workbench.springbootrabbitmq.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling //启用任务调度
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Scheduled(fixedDelay = 3000)  //3s
    public void sendMes(String msg) {
        this.rabbitTemplate.convertAndSend("hello",msg);
    }

}
