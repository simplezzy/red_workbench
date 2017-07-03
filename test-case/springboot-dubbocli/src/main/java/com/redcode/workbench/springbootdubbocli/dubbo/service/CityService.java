package com.redcode.workbench.springbootdubbocli.dubbo.service;

import com.redcode.workbench.springbootdubbocli.domain.City;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */

public interface CityService {

    City findCityByName(String cityName);
}
