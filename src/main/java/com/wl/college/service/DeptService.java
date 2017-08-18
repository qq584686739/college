package com.wl.college.service;

import com.wl.college.entity.Dept;
import com.wl.college.entity.User;

import java.util.List;

/**
 * Created by DIY on 2017/8/17.
 */
public interface DeptService {

    /**
     * 基本信息注册
     * @param dept 平台信息
     * @return
     */
    Dept register(Dept dept);

    /**
     * 完善信息
     * @param dept
     * @return
     */
    Dept perfection(Dept dept);

    /**
     * 修改状态
     * @param id
     * @param state
     */
    void changeState(Integer id, String state);

    /**
     * dept 列表
     * @param dept
     * @param offset
     * @param limit
     * @param field
     * @param rule
     * @return
     */
    List<Dept> list(Dept dept, Integer offset, Integer limit, String field, String rule);

    Integer total(Dept dept);
}
