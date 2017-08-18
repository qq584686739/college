package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Dept;
import com.wl.college.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/17.
 */
@RestController
@RequestMapping("/depts")
public class DeptController {
    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 管理员新增平台
     * @param dept
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Dept> register(Dept dept) {
        return new BaseResult<>(true, deptService.register(dept));
    }

    /**
     * 更新平台文件信息
     * @param dept
     * @return
     */
    @PutMapping(value = "/perfection", produces = {"application/json;charset=UTF-8"})
    public BaseResult<Dept> perfection(Dept dept) {
        return new BaseResult<>(true, deptService.perfection(dept));
    }

    /**
     * 修改平台状态
     * @param id
     * @param state
     * @return
     */
    @PutMapping(value = "/state", produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> changeState(Integer id,String state) {
        deptService.changeState(id,state);
        return new BaseResult<>(true,null);
    }

    /**
     * 平台列表
     * @param dept
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Dept> list(@RequestParam(value = "dept", required = false) Dept dept,
                                           @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
                                           @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
                                           @RequestParam(value = "sort", required = false, defaultValue = "id")String sort,
                                           @RequestParam(value = "order", required = false, defaultValue = "ASC")String order) {
        return new BootStrapTableResult<>(deptService.total(dept), deptService.list(dept,offset,limit,sort,order));
    }



}
