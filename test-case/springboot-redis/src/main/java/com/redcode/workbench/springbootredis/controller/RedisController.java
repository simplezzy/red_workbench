package com.redcode.workbench.springbootredis.controller;

import com.redcode.workbench.springbootredis.domain.Message;
import com.redcode.workbench.springbootredis.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
* Created by zhiyu.zhou on 2017/6/27.
*/
@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/index")
    public String redisIndex() {
        return "redis index" + " " + new Date();
    }

    @GetMapping("/get/{id}")
    public Message getMsg(@PathVariable("id") Long id) {
        return messageService.findMessageById(id);
    }
}

