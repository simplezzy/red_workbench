package com.redcode.workbench.springbootredis.service;

import com.redcode.workbench.springbootredis.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by zhiyu.zhou on 2017/6/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;
    @Test
    public void findMessageById() throws Exception {
        Message message = messageService.findMessageById(0L);
        System.out.println("message:" + message);
    }

    @Test
    public void insertMessage() throws Exception {
        Message message = new Message();
        for(int i = 0; i < 5; i++) {
            message.setId(Long.valueOf(i));
            message.setMessageId(Long.valueOf(i + 10));
            message.setMessageInfo("redis" + i);
            message.setCreateTime(new Date());
            messageService.insertMessage(message);
        }

    }

}