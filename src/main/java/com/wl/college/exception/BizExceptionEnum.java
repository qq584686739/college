package com.wl.college.exception;

/**
 * 业务异常类
 */
public enum BizExceptionEnum {
    //数据库操作异常
    DB_INSERT_RESULT_ERROR(99990001, "db insert error"),
    DB_UPDATE_RESULT_ERROR(99990002, "db update error"),
    DB_SELECTONE_IS_NULL(99990003, "db select return null"),

    // 用户相关异常
    INVALID_USER(10010001, "用户不存在"),
    INVALID_PASSWORD(10010002, "密码错误"),
    NOT_LOGGED_IN(10010003, "未登录"),
    NO_PERMISSIONS(10010004, "没有相应权限"),
    INVALID_VALIDATION(10010005, "验证码错误"),

    // aliyun相关异常
    //邮件发送异常
    INVALID_TO_ADDRESS(10020001, "邮件发送失败, 地址不存在"),
    INVALID_SEND_EMAIL_SPAM(10020002, "邮件发送失败, 被反垃圾系统检测为垃圾邮件"),
    INVALID_SEND_EMAIL(10020003, "邮件发送失败"),


//------------------------------------------
    //*登录错误*
    //没有登录，退出登录失败
    ERROR_LOGOUT(90001,"没有登录不能退出登录！"),

//------------------------------------------


    // 系统异常
    INNER_ERROR(99980001, "系统错误");


    private int code;
    private String message;

    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
