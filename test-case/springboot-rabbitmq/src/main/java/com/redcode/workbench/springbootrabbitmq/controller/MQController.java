package com.redcode.workbench.springbootrabbitmq.controller;

import com.redcode.workbench.springbootrabbitmq.producers.Sender;
import com.redcode.workbench.springbootrabbitmq.producers.Sender1;
import com.redcode.workbench.springbootrabbitmq.producers.SenderTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("mq")
public class MQController {

    @Autowired
    private Sender sender;

    @Autowired
    private Sender1 sender1;

    @Autowired
    private SenderTopic senderTopic;

    @RequestMapping("/index")
    public String indexTest() {
        return "RabbitMQ";
    }

    @GetMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg) {
        sender.sendMes(msg);
        return "mq send success!" + new Date();
    }

    @GetMapping("/send/one2many")
    public String sendOneToMany() {
        for (int i = 0; i < 5; i++) {
            sender.sendMes("oneToManyMsg:" + i);
        }
        return "success: one msg is consumed by many";
    }

    @GetMapping("/send/many2many")
    public String sendManyToMany() {
        for (int i = 0; i < 5; i++) {
            sender.sendMes("senderMsg:" + i);
            sender1.sendMsg("sender1_Msg:" + i);
        }
        return "success: many Sender is consumed by many";
    }

    @GetMapping("/send/topic")
    public String sendTopic() {
        senderTopic.sendMessage("msg1:========");
        senderTopic.sendMessages("msg2:########");
        return "success:topic exchange";
    }

}
