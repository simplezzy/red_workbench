package com.redcode.workbench.springbootdubbocli.dubbo.service;

import com.redcode.workbench.springbootdubbocli.domain.City;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
@Component
public class CityDubboConsumerService {

    @Reference
    CityService cityService;

    public void printCity() {
        City city = cityService.findCityByName("wuhan");
        System.out.println("city:" + city.toString());
    }
}
