package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Permission;
import com.wl.college.enums.OperationType;
import com.wl.college.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public BaseResult listAll() {
        log.info("invoke----------/permission.GET");
        List<Permission> list;
        list = permissionService.findAll();
        return new BaseResult<>(true,list);
    }

    /**
     * 创建一个permission
     * @param permission
     * @return BaseResult<Object>
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> create(@RequestParam Permission permission) {
        log.info("invoke----------/permission/create.POST");
        permissionService.createPermission(permission);
        return new BaseResult<>(true, null);
    }

    /**
     * 删除一个permission
     * @param permission
     * @return BaseResult<Object>
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> delete(@RequestParam Permission permission) {
        log.info("invoke----------/permission/delete/{id}.DELETE");
        permissionService.createPermission(permission);
        return new BaseResult<>(true, null);
    }
}