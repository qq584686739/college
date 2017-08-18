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
        mockMvc.perform(post("/depts")
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
                .param("pid","8")
        ).andDo(print()).andExpect(status().isOk());;
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(put("/depts/perfection")
                .param("license","license")
                .param("licenseImg","licenseImg")
                .param("manager.idCard","610102198005121854")
                .param("manager.idCardFront","manager.idCardFront")
                .param("manager.idCardBack","manager.idCardBack")
                .param("manager.idCardWith","manager.idCardWith")
                .param("manager.bankCard","manager.bankCard")
                .param("manager.bankCardFront","manager.bankCardFront")
                .param("manager.bankCardBack","manager.bankCardBack")
                .param("id","10")
        ).andDo(print()).andExpect(status().isOk());;
    }

    @Test
    public void changeState() throws Exception {
        mockMvc.perform(put("/depts/state")
                .param("state","0")
                .param("id","10")
        ).andDo(print()).andExpect(status().isOk());;
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/depts")
        ).andDo(print()).andExpect(status().isOk());;
    }

}