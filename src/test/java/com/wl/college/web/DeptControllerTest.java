package com.wl.college.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by DIY on 2017/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
@WebAppConfiguration
public class DeptControllerTest {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void register() throws Exception {
        mockMvc.perform(post("/dept")
                .param("name","college")
                .param("country","country")
                .param("city","city")
                .param("town","town")
                .param("address","address")
                .param("area","area")
                .param("expirationTime",new Date().toString())
                .param("address","address")
                .param("manager.name","zhangsan")
                .param("manager.mail","11@11.com")
                .param("manager.phone","123456")
                .param("manager.fullName","sssss")
                .param("bankCard","bankCard")
        ).andDo(print()).andExpect(status().isOk());;
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(put("/update")
                .param("license","license")
                .param("licenseImg","licenseImg")
                .param("manager.idCard","manager.idCard")
                .param("manager.idCardFront","manager.idCardFront")
                .param("manager.idCardBack","manager.idCardBack")
                .param("manager.idCardWith","manager.idCardWith")
                .param("manager.bankCard","manager.bankCard")
                .param("manager.bankCardFront","manager.bankCardFront")
                .param("manager.bankCardBack","manager.bankCardBack")
                .param("id","8")
        ).andDo(print()).andExpect(status().isOk());;
    }

}