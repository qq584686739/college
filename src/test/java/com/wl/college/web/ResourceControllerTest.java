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
 * Created by DIY on 2017/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
@WebAppConfiguration
public class ResourceControllerTest {

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
        mockMvc.perform(post("/resources")
                .param("name","name")
                .param("author","author")
                .param("url","url")
                .param("type","type")
                .param("number","1111")
                .param("grade","5")
                .param("difficulty","2")
                .param("sectionId","2")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(put("/resources")
                .param("name","name1")
                .param("id","1")
                .param("author","auth1or")
                .param("url","url")
                .param("type","type")
                .param("number","1111")
                .param("grade","5")
                .param("difficulty","2")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/resources")
                .param("id","1")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(get("/resources")
                        .param("sectionId","2")
//                .param("name","name1")
//                .param("id","1")
//                .param("author","auth1or")
//                .param("url","url")
//                .param("type","type")
//                .param("number","1111")
//                .param("grade","5")
//                .param("difficulty","2")
        ).andDo(print()).andExpect(status().isOk());
    }

}