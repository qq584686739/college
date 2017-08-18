package com.wl.college.web;

import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.User;
import com.wl.college.enums.OperationType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);


    /**
     * 根据条件获取一部分user
     * @param user 根据条件查询
     * @param offset 起始条数
     * @param limit  需要条数
     * @param gender 性别查询
     * @param dept_id 所属平台查询
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions(OperationType.USER_VIEW)
    public BootStrapTableResult<Object> list(
            @RequestParam(value = "user", required = false) User user,
            @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
            @RequestParam(value = "gender", required = false, defaultValue = "0")String gender,
            @RequestParam(value = "dept_id", required = false, defaultValue = "1")String dept_id,
            @RequestParam(value = "sort_field", required = false, defaultValue = "id")String sort_field,
            @RequestParam(value = "sort_rule", required = false, defaultValue = "ASC")String sort_rule) {
        log.info("invoke----------/user.GET");


        return null;
    }

}
