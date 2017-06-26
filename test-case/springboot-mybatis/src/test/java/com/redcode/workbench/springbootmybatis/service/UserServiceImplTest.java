package com.redcode.workbench.springbootmybatis.service;

import com.redcode.workbench.springbootmybatis.dao.UserMapper;
import com.redcode.workbench.springbootmybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utils.BaseTest;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserById() throws Exception {
        User user = userService.findUserById(2);
        System.out.println("User:"+ user.toString());
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        for(int i = 10; i < 5; i++) {
            user.setId(i);
            user.setLastName("redcode" + i);
            user.setAge(10 + i);
            userService.insertUser(user);
        }
    }

}