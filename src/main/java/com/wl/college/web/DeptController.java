package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Dept;
import com.wl.college.entity.User;
import com.wl.college.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Dept> register(Dept dept) {
        try {
            return  new BaseResult(true,deptService.register(dept));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new BaseResult(false,null);
    }

    @PutMapping(value = "/update" , produces = {"application/json;charset=UTF-8"})
    public BaseResult<Dept> update(Dept dept) {

        try {
            return  new BaseResult(true, deptService.update(dept));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new BaseResult(false,null);
    }
}
