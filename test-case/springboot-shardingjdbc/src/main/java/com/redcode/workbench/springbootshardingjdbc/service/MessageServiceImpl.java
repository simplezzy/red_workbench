package com.redcode.workbench.springbootshardingjdbc.service;

import com.redcode.workbench.springbootshardingjdbc.dao.MessageMapper;
import com.redcode.workbench.springbootshardingjdbc.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhiyu.zhou on 2017/6/29.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message findMsgByMessageId(int messageId) {
        return messageMapper.findMsgByMessageId(messageId);
    }
}
