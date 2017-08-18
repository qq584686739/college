package com.wl.college.exception;


import com.aliyuncs.exceptions.ClientException;
import com.wl.college.dto.BaseResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 未登录
     *
     * @param response
     * @return
     */
    @ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class})
    public BaseResult<Object> authenticationException(HttpServletResponse response) {
        response.setStatus(401);
        return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.NOT_LOGGED_IN));
    }

    /**
     * 没有相应权限
     *
     * @return
     */
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public BaseResult<Object> authorizationException() {
        return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.NO_PERMISSIONS));
    }

    /**
     * 邮件发送失败
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ClientException.class)
    public BaseResult<Object> clientException(ClientException e) {
        if (e.getErrCode().equals("InvalidToAddress.Spam")) {
            return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.INVALID_SEND_EMAIL_SPAM));
        }
        if (e.getErrCode().equals("InvalidToAddress")) {
            return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.INVALID_TO_ADDRESS));
        }
        return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.INVALID_SEND_EMAIL));
    }

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public BaseResult<Object> bizException(BizException e) {
        return new BaseResult<>(false, new BizExceptionMessage(e.getBizExceptionEnum()));
    }

//    /**
//     * 整体异常
//     *
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    public BaseResult<Object> exception(HttpServletRequest request, Exception e) {
//        e.printStackTrace();
//        // TODO
//        LOG.error("uri: " + request.getRequestURI());
//        LOG.error(e.getClass().getName());
//        LOG.error(e.toString());
//        return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.INNER_ERROR));
//    }
}
