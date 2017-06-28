package com.redcode.workbench.springbootredis.service;

import com.redcode.workbench.springbootredis.domain.Message;

/**
 * Created by zhiyu.zhou on 2017/6/27.
 */
public interface MessageService {

    Message findMessageById(Long id);

    void insertMessage(Message message);
}
