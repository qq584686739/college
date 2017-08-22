package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Authentication;
import com.wl.college.entity.User;
import com.wl.college.service.AuthenticationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/22.
 */
@RestController
@RequestMapping("/authentications")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * user信息实名认证
     * @return BaseResult
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Authentication> authentication(Authentication authentication)  {
        authentication.setState("1");
        return new BaseResult<>(true, authenticationService.create(authentication));
    }

    /**
     * 审核
     * @return BaseResult
     */
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Authentication> update(Integer id,String state)  {
        return new BaseResult<>(true, authenticationService.check(id,state));
    }

    /**
     * 审核列表 平台
     * @return BaseResult
     */
    @GetMapping(value = "/dept",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Authentication> deptList(Authentication authentication,
                                                     @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
                                                     @RequestParam(value = "sort", required = false, defaultValue = "authentication.id") String sort,
                                                     @RequestParam(value = "order", required = false, defaultValue = "ASC") String order)  {
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        User user = new User();
        user.setDeptId(id);
        authentication.setUser(user);
        return new BootStrapTableResult<>(authenticationService.total(authentication),
                authenticationService.list(authentication,offset,limit,sort,order));
    }

    /**
     * 审核列表 ADMIN
     * @return BaseResult
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Authentication> list(Authentication authentication,
                                                     @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
                                                     @RequestParam(value = "sort", required = false, defaultValue = "authentication.id") String sort,
                                                     @RequestParam(value = "order", required = false, defaultValue = "ASC") String order)  {
        return new BootStrapTableResult<>(authenticationService.total(authentication),
                authenticationService.list(authentication,offset,limit,sort,order));
    }

    /**
     * 审核列表 USER
     * @return BaseResult
     */
    @GetMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Authentication> userList(Authentication authentication,
                                                     @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
                                                     @RequestParam(value = "sort", required = false, defaultValue = "authentication.id") String sort,
                                                     @RequestParam(value = "order", required = false, defaultValue = "ASC") String order)  {
        authentication.setUserId((Integer) SecurityUtils.getSubject().getPrincipal());
        return new BootStrapTableResult<>(authenticationService.total(authentication),
                authenticationService.list(authentication,offset,limit,sort,order));
    }
}
