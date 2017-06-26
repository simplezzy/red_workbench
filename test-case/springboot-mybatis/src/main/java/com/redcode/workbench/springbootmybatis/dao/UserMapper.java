package com.redcode.workbench.springbootmybatis.dao;

import com.redcode.workbench.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserById(Integer id);

    void insertUser(User user);
}
