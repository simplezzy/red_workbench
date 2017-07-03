package com.redcode.workbench.springbootdubbos.dubbo.service;

import com.redcode.workbench.springbootdubbos.domain.City;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
public interface CityService {

    City findCityByName(String cityName);
}
