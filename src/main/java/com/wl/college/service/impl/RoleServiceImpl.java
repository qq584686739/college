package com.wl.college.service.impl;

import com.wl.college.dao.RoleDao;
import com.wl.college.entity.Role;
import com.wl.college.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 返回所有的role
     * @return List<Role>
     */
    @Override
    public List<Role> listAll() {
        return roleDao.findAll();
    }

}
