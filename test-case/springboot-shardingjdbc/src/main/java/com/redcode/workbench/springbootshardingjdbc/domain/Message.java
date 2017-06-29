package com.redcode.workbench.springbootshardingjdbc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhiyu.zhou on 2017/6/26.
 */

//@Data
public class Message implements Serializable{

    private Long id;

    private Integer messageId;

    private String messageInfo;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageId=" + messageId +
                ", messageInfo='" + messageInfo + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
