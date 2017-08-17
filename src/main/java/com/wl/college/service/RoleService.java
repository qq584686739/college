package com.wl.college.service;


import com.wl.college.entity.Role;

import java.util.List;


public interface RoleService {

    /**
     * 返回所有的role
     *
     * @return List<Role>
     */
    List<Role> listAll();

}
