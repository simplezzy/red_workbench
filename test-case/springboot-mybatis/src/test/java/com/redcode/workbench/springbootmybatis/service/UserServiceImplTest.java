package com.redcode.workbench.springbootmybatis.service;

import com.redcode.workbench.springbootmybatis.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import utils.BaseTest;

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