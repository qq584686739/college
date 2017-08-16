package com.wl.college.filter;


import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


@Component
public class SysUserFilter extends PathMatchingFilter {

//    @Autowired
//    private UserService userService;

    /**
     * 在onPreHandle中，当onPreHandle匹配一个路径后，
     * 会调用onPreHandle方法并将路径绑定参数配置传给mappedValue；
     * 然后可以在这个方法中进行一些验证（如果角色授权），
     * 如果验证失败可以返回false中断流程；默认返回true；
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Integer id = null;
//        try{
//            id = (Integer) SecurityUtils.getSubject().getPrincipal();
//        }catch (Exception e){
//
//        }
//        request.setAttribute(Constants.CURRENT_USER, userService.findById(id));
//        return true;



        return true;
    }
}
