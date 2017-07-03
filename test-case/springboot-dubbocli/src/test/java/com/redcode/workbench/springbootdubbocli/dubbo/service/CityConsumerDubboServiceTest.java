package com.redcode.workbench.springbootdubbocli.dubbo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redcode.workbench.springbootdubbocli.BaseTest;
import com.redcode.workbench.springbootdubbocli.domain.City;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Base64;

import static org.junit.Assert.*;

/**
 * Created by zhiyu.zhou on 2017/7/1.
 */
public class CityConsumerDubboServiceTest extends BaseTest{

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void getCityInfo() throws Exception {

        String uri = "/dubbo/city";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String response = mvcResult.getResponse().getContentAsString();

        System.out.println("response:" + response + "\nstatus:" + status);
    }

}