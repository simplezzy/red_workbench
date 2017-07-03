package com.redcode.workbench.springbootdubbos.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.redcode.workbench.dubbo.api.CityService;
import com.redcode.workbench.dubbo.vo.City;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
//注册为Dubbo服务
@Service
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
