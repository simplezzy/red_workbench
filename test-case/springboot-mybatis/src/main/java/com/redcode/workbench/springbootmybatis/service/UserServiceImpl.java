package com.redcode.workbench.springbootmybatis.service;

import com.redcode.workbench.springbootmybatis.dao.UserMapper;
import com.redcode.workbench.springbootmybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
