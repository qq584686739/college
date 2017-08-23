package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Role;
import com.wl.college.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RoleController
 * Created by XJH on 2017/8/22.
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 查询所有的role
     *
     * @return 返回所有的role
     */
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> listAll() {
        log.info("invoke----------/role.GET");
        List<Role> roles;
        roles = roleService.listAll();
        return new BaseResult<>(true, roles);
    }

    /**
     * 创建一个role并分配权限
     *
     * @param role        role的信息
     * @param permissions role所对应的permissionIds
     * @return true：创建成功，false：创建失败
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult createRole(@RequestParam Role role,
                                 @RequestParam(value = "permissions[]", required = false) List<Integer> permissions) {
        log.info("invoke----------/role/create.POST");
        roleService.createRole(role, permissions);      //创建角色同时分配权限
        return new BaseResult<>(true, null);
    }


    /**
     * 修改一个role并重新分配权限
     * 如果不传permissions则默认只修改role的信息，不对该role重新授权
     * 如果传permissions则对role重新授权
     *
     * @param role        role的信息
     * @param permissions role所对应的permissionIds
     * @return true：创建成功，false：创建失败
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public BaseResult updateRole(@RequestParam Role role,
                                 @RequestParam(value = "permissions[]", required = false) List<Integer> permissions) {
        log.info("invoke----------/role/update.PUT");
        roleService.updateRole(role, permissions);      //更新角色同时分配权限
        return new BaseResult(true, null);
    }


    /**
     * 根据id获得一个role
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getOne", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Role> getOne(@RequestParam Integer id) {
        log.info("invoke----------/role/getOne.GET");
        return new BaseResult<>(true, roleService.getOne(id));      //根据id获得一个role并返回
    }

    /**
     * 删除role
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> delete(@PathVariable("id") Integer id) {
        log.info("invoke----------/role/delete/{id}.DELETE");
        roleService.deleteRole(id);
        return new BaseResult<>(true, null);
    }

    /**
     * 根据role的id获得这个id下的所有permissions
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPermissions", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult getPermissionByRoleId(Integer id) {
        log.info("invoke----------/role/getPermissions.GET");
        return new BaseResult<>(true, roleService.getPermissionByRoleId(id));      //根据id获得一个role并返回
    }

}
