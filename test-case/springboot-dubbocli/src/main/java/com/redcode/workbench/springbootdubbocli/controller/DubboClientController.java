package com.redcode.workbench.springbootdubbocli.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.redcode.workbench.dubbo.api.CityService;
import com.redcode.workbench.dubbo.vo.City;
import com.redcode.workbench.springbootdubbocli.dubbo.service.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Reference
    CityService cityService;

    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;

    @RequestMapping("/index")
    public String dubboIndex() {
        return "dubbo client index" + " " + new Date();
    }

    @GetMapping("/city0")
    public City getCityInfo() {
        City city = cityService.findCityByName("wuhan");
        System.out.println("city info:" + city);
        return city;
    }

    @GetMapping("/city")
    public City getCityInfoFromConsumer() {
        City city = cityDubboConsumerService.getCityInfo();
        System.out.println("city info:" + city);
        return city;
    }


}
