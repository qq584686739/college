package com.wl.college.service;

import com.wl.college.entity.Dept;
import com.wl.college.entity.User;

/**
 * Created by DIY on 2017/8/17.
 */
public interface DeptService {
    Dept register(Dept dept, User user);
}
