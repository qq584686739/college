package com.wl.college.web;

import com.wl.college.dao.CourseDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by DIY on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
@WebAppConfiguration
public class OrderControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private CourseDao courseDao;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }


    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/orders")
                .param("type","type")
                .param("resourceId","20")
                .param("state","1")
                .param("userId","1")
                .param("credits","0")
                .param("amount","11.1")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(put("/orders")
//                .param("type","type")
//                .param("resourceId","20")
                .param("state","0")
                .param("id","6")
//                .param("credits","0")
//                .param("amount","11.1")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/orders/6")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/orders")
                .param("deptId","13")
        ).andDo(print()).andExpect(status().isOk());
    }

}