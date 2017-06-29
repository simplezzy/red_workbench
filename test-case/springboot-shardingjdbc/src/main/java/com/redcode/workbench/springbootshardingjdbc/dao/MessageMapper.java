package com.redcode.workbench.springbootshardingjdbc.dao;


import com.redcode.workbench.springbootshardingjdbc.domain.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    Integer insert(Message message);

    Message findMsgByMessageId(int messageId);

}