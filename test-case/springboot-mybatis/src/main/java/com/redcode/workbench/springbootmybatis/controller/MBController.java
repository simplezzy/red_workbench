package com.redcode.workbench.springbootmybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("mb")
public class MBController {

    @GetMapping("/index")
    public String mbIndex() {
        return "mybatis index" +"--"+ new Date();
    }
}
