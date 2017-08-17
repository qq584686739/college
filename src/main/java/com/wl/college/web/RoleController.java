package com.wl.college.web;

import com.alibaba.fastjson.JSONArray;
import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Role;
import com.wl.college.enums.Constants;
import com.wl.college.enums.OperationType;
import com.wl.college.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的role
     * @return 返回所有的role
     */
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions(OperationType.ROLE_VIEW)
    public BaseResult<Object> listAll() {
        log.info("invoke----------/role.GET");
        List<Role> roles;
        try {
            roles = roleService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult<>(false, null);
        }
        return new BaseResult<>(true, roles);
    }

    /**
     * 创建一个role并分配权限
     * @param role role的信息
     * @param permissions role所对应的permissionIds
     * @return true：创建成功，false：创建失败
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions(OperationType.ROLE_CREATE)
    public BaseResult<Object> create(Role role, String permissions) {
        log.info("invoke----------/role/create.POST");
        List<Integer> permissionsList = new ArrayList<>();
        try {
            JSONArray jsonlist = JSONArray.parseArray(permissions);
            if (jsonlist != null) {
                for (int i = 0; i < jsonlist.size(); i++) {
                    permissionsList.add(jsonlist.getInteger(i));
                }
            }
            roleService.createRole(role, permissionsList);      //创建角色同时分配权限
        }catch (Exception e) {
            return new BaseResult<>(false, Constants.CREATE_ERROR);         //创建失败
        }
        return new BaseResult<>(true, null);
    }
}
