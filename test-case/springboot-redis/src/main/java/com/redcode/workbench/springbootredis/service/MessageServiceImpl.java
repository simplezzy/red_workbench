package com.redcode.workbench.springbootredis.service;

import com.redcode.workbench.springbootredis.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhiyu.zhou on 2017/6/27.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Message findMessageById(Long id) {
        ValueOperations<String, Message> operations = redisTemplate.opsForValue();

        //cache中存在
        if(redisTemplate.hasKey(id.toString())) {
            Message message = operations.get(id.toString());
            return message;
        }
        return null;
    }

    @Override
    public void insertMessage(Message message) {
        ValueOperations<String, Message> operations = redisTemplate.opsForValue();
        operations.set(message.getId().toString(), message,10, TimeUnit.SECONDS);
    }


}
