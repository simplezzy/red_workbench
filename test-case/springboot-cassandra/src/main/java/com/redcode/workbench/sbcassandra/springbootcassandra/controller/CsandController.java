package com.redcode.workbench.sbcassandra.springbootcassandra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("csd")
public class CsandController {

    @GetMapping("/index")
    public String indexTest() {
        return "cassandra index success!";
    }
}
