package com.redcode.workbench.springbootdubbocli.dubbo.service;

import com.redcode.workbench.springbootdubbocli.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zhiyu.zhou on 2017/7/3.
 */
public class CityDubboConsumerServiceTest extends BaseTest{

    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;

    @Test
    public void printCity() throws Exception {
        cityDubboConsumerService.printCity();
    }

}