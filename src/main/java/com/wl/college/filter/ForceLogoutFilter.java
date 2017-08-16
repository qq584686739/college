package com.wl.college.filter;

import com.wl.college.enums.Constants;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ForceLogoutFilter extends AccessControlFilter {

    /**
     * 表示是否允许访问，mappedValue是配置中拦截参数部分，允许访问则返回true，不允许则返回false
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Session session = getSubject(request, response).getSession(false);
        if (session == null) {
            return true;
        }

        //如果被管理员踢出去，则return false，没有被踢出去，则返回true
        return session.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY) == null;
    }

    /**
     * 表示当访问拒绝时是否处理了；如果返回true则表示继续处理，如果返回false则表示拦截器已经处理了
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        try {
            getSubject(request, response).logout();//强制退出
        } catch (Exception e) {/*ignore exception*/}

        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
        System.out.println("test.loginUrl = " + loginUrl);
        WebUtils.issueRedirect(request, response, loginUrl);
        return false;
    }
}
