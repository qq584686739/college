package com.wl.college.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;


/**
 * 没有权限处理
 * 检查权限
 */
@ControllerAdvice
@Component
public class DefaultExceptionHandler {
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void processUnauthenticatedException(HttpServletResponse response) {
        // TODO: 2017/8/17 待处理
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
        System.out.println("没有权限处理！");
    }
}
