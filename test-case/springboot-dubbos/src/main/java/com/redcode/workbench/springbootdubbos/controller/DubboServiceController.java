package com.redcode.workbench.springbootdubbos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */

@RestController
@RequestMapping("/dubbo")
public class DubboServiceController {

    @RequestMapping("/index")
    public String dubboserviceIndex() {
        return "dubbo service index" + " " + new Date();
    }
}
