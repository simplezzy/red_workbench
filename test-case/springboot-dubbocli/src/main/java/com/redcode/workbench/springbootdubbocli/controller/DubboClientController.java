package com.redcode.workbench.springbootdubbocli.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.redcode.workbench.springbootdubbocli.domain.City;
import com.redcode.workbench.springbootdubbocli.dubbo.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
@RestController
@RequestMapping(value = "/dubbo")
public class DubboClientController {

    @Reference(version = "1.0.0")
    CityService cityService;

    @RequestMapping("/index")
    public String dubboIndex() {
        return "dubbo client index" + " " + new Date();
    }

    @GetMapping("/city")
    public City getCityInfo() {
        City city = cityService.findCityByName("wuhan");
        System.out.println("city info:" + city);
        return city;
    }


}
