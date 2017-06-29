package com.redcode.workbench.springbootshardingjdbc.service;

import com.redcode.workbench.springbootshardingjdbc.BaseTest;
import com.redcode.workbench.springbootshardingjdbc.domain.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zhiyu.zhou on 2017/6/29.
 */
public class MessageServiceTest extends BaseTest{

    @Autowired
    private MessageService messageService;

    @Test
    public void findMsgByMessageId() throws Exception {
        Message message = messageService.findMsgByMessageId(10);
        System.out.println("message:" + message.toString());
    }
}