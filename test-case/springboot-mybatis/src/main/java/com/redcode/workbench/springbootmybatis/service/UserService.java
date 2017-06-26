package com.redcode.workbench.springbootmybatis.service;

import com.redcode.workbench.springbootmybatis.entity.User;


public interface UserService {

    User findUserById(Integer id);

    void insertUser(User user);
}
