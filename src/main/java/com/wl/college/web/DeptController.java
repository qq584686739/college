package com.wl.college.web;

import com.wl.college.entity.Dept;
import com.wl.college.entity.User;
import com.wl.college.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DIY on 2017/8/17.
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object register(Dept dept) {
        try {
            return deptService.register(dept);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object update(Dept dept) {
        deptService.update(dept);
        return null;
    }
}
