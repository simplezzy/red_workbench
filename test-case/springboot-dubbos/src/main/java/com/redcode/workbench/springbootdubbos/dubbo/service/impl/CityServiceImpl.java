package com.redcode.workbench.springbootdubbos.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.redcode.workbench.springbootdubbos.domain.City;
import com.redcode.workbench.springbootdubbos.dubbo.service.CityService;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
//注册为Dubbo服务
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {

    @Override
    public City findCityByName(String cityName) {
        City city = new City();
        city.setId(3L);
        city.setCityName("wuhan");
        city.setDescription("三大火炉！");
        return city;
    }
}
