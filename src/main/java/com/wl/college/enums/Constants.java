package com.wl.college.enums;


public class Constants {
    public static final String CURRENT_USER = "user";
    /**用户被踢出去*/
    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";

    //图片文件数据库存储地址
    public static final String USER_FILE_SAVE_RELATIVE_PATH = "/img/";
    //图片文件服务器存储地址
    public static final String USER_FILE_SAVE_ABSOLUTE_PATH = "/data/nginx/html/my/img/";


    //登录信息
    //登陆成功
    public static final String LOGIN_SUCCESS = "You have logged in successfully!";
    //您还没有登录
    public static final String NOT_LOGIN = "You are not logged in yet";
    //您的账号在异地登录
    public static final String DIFFERENT_ADDRESS_LOGIN = "Your account is logged on in different places. Please log in again!";
    //您已经被管理员踢出，请重新登录
    public static final String KICKOUT = "You have been kicked out by the administrator. Please log in again!";
    /**没有登录，退出登录失败*/
    public static final String ERROR_LOGOUT = "You are not logged in. You cannot quit";
    //rank参数错误，请重试
    public static final String RANK_ERROR = "Parameter error by \"rank\"";
    //用户名或密码错误
    public static final String LOGIN_FAIL = "ERROR Incorrect username or password";

    //用户不存在
    public static final String NOT_FOUND_USER = "User does not exist";

    //创建失败
    public static final String CREATE_ERROR = "Failed to create";

    //删除失败
    public static final String DELETE_ERROR = "Failed to delete";

    //修改密码
    //修改密码失败
    public static final String ERROR_MODIFY_PASSWORD = "Failed to modify password";
    //修改密码成功
    public static final String SUCCESS_MODIFY_PASSWORD = "Password successfully modified";

    //修改管理员state失败
    public static final String UPDATE_USER_STATE_ERROR = "Failed to modify user status code";

    //修改user_role失败
    public static final String UPDATE_USER_ROLE_ERROR = "Failed to modify user_role";

    //修改role失败
    public static final String UPDATE_ROLE_ERROR = "Failed to update role";





    //返回的状态码-正常
    public static final Integer GOOD_RESPONSE_STATE = 200;
    //返回的状态码-异地登录
    public static final Integer DIFFERENT_ADDRESS_RESPONSE_STATE = 901;
    /**返回的状态码-被管理员踢出**/
    public static final Integer KICKOUT_RESPONSE_STATE = 902;
    /**返回的状态码-没有登录*/
    public static final Integer NOT_LOGIN_RESPONSE_STATE = 903;

}
