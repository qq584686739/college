package com.wl.college.web;

import com.alibaba.fastjson.JSONArray;
import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Permission;
import com.wl.college.entity.Role;
import com.wl.college.enums.Constants;
import com.wl.college.enums.OperationType;
import com.wl.college.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);


    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 获取所有的权限
     * @return BootStrapTableResult<Permission>
     */
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Permission> listAll() {
        log.info("invoke----------/permission.GET");
        List<Permission> list;
        try {
            list = permissionService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new BootStrapTableResult<>(11,list);
    }

    /**
     * 创建一个permission
     * @param permission
     * @return BaseResult<Object>
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions(OperationType.PERMISSION_CREATE)
    public BaseResult<Object> create(Permission permission) {
        log.info("invoke----------/permission/create.POST");
        try {
            permissionService.createPermission(permission);
        }catch (Exception e) {
            return new BaseResult<>(false, Constants.CREATE_ERROR);         //创建失败
        }
        return new BaseResult<>(true, null);
    }
}