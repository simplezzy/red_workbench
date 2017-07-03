package com.redcode.workbench.dubbo.api;

import com.redcode.workbench.dubbo.vo.City;

/**
 * Created by zhiyu.zhou on 2017/7/3.
 */
public interface CityService {

    City findCityByName(String cityName);
}
