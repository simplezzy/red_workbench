package com.redcode.workbench.springbootdubbocli.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.redcode.workbench.dubbo.api.CityService;
import com.redcode.workbench.dubbo.vo.City;
import org.springframework.stereotype.Component;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
@Component
public class CityDubboConsumerService {

    @Reference
    private CityService cityService;

    public void printCity() {
        City city = cityService.findCityByName("wuhan");
        System.out.println("city:" + city.toString());
    }

    public City getCityInfo() {
        City city = cityService.findCityByName("wuhan");
        return city;
    }
}
