package com.wl.college.web;

import com.wl.college.dao.CourseDao;
import com.wl.college.entity.Course;
import com.wl.college.service.CourseService;
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
public class CourseControllerTest {
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
        mockMvc.perform(post("/courses")
                .param("name","name")
                .param("price","1111.21")
                .param("deptId","13")
                .param("icon","icon")
                .param("pid","17")
                .param("details","details")
                .param("description","description")
                .param("number","11")
        ).andDo(print()).andExpect(status().isOk());;
    }

    @Test
    public void update() throws Exception {
        Course byId = courseDao.findById(19);
        System.out.println(byId);
        new Date(byId.getUpdateTime().getTime()-14*60* 1000);
        System.out.println();
        mockMvc.perform(put("/courses")
                .param("name","n111ame")
                .param("price","1111.21")
                .param("deptId","13")
                .param("icon","icon")
                .param("pid","18")
                .param("details","details")
                .param("description","description")
                .param("number","11")
                .param("id","19")
                .param("updateTime",new Date(byId.getUpdateTime().getTime()-14*60*60 *1000).toString() )
        ).andDo(print()).andExpect(status().isOk());
    }

}