package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import com.wl.college.enums.OperationType;
import com.wl.college.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 根据条件获取一部分user
     * @param user      筛选条件user
     * @param offset    起始数
     * @param limit     需要数
     * @param sort_field    排序的字段
     * @param sort_rule     排序的规则
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
//    @RequiresPermissions(OperationType.USER_VIEW)
    public BootStrapTableResult list(
            @RequestParam(value = "user", required = false) User user,
            @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
            @RequestParam(value = "sort", required = false, defaultValue = "id")String sort_field,
            @RequestParam(value = "order", required = false, defaultValue = "ASC")String sort_rule) {
        log.info("invoke----------/user.GET");
        Integer total = userService.findCount(user);
        List<User> list = userService.listUser(user, offset, limit, sort_field, sort_rule);
        return new BootStrapTableResult<>(total, list);
    }


    /**
     * 查找自己的roles
     * @return BaseResult
     */
    @GetMapping(value = "/mySelfRoles", produces = {"application/json;charset=UTF-8"})
//    @RequiresPermissions(OperationType.USER_VIEW)
    // TODO: 2017/8/18 需要登录注解
    public BaseResult mySelfRoles() {
        log.info("invoke----------/user/mySelfRoles.GET");
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        List<Role> list = userService.hasRoles(id, null, null, null);
        return new BaseResult<>(true, list);
    }

    /**
     *
     */
    @GetMapping(value = "/otherRoles", produces = {"application/json;charset=UTF-8"})
    //    @RequiresPermissions(OperationType.USER_VIEW)
    // TODO: 2017/8/18 需要有看别人角色的权限
    public BaseResult otherRoles(@RequestParam Integer id){
        log.info("invoke----------/user/otherRoles.GET");
        List<Role> list = userService.hasRoles(id, null, null, null);
        return new BaseResult<>(true, list);
    }
}
