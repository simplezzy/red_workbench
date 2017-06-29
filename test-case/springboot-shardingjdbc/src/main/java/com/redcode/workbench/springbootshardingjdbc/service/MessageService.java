package com.redcode.workbench.springbootshardingjdbc.service;

import com.redcode.workbench.springbootshardingjdbc.domain.Message;
import org.springframework.stereotype.Service;

/**
 * Created by zhiyu.zhou on 2017/6/29.
 */

public interface MessageService {

    Message findMsgByMessageId(int messageId);
}
