package com.wl.college.enums;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常 定义异常时，需要先确定异常所属模块。 例如：无效用户可以定义为 [10010001]
 * 前四位数为系统模块编号，后4位为错误代码 ,唯一。
 *
 * @author yugoh
 */
public enum ResultEnum {

    // 数据库相关操作异常
    DB_INSERT_RESULT_ERROR(99990001, "db insert error"),
    DB_UPDATE_RESULT_ERROR(99990002, "db update error"),
    DB_DELETE_RESULT_ERROR(99990004, "db delete error"),
    DB_SELECTONE_IS_NULL(99990003, "db select return null"),

    // 系统异常
    INNER_ERROR(99980001, "inner error"),
    TOKEN_IS_ILLICIT(99980002, "token is illicit"),
    SESSION_IS_OUT_TIME(99980003, "session is out time"),
    SECURITY_CODE_IS_ILLICIT(99980004, "security code is illicit"),

    // 用户相关异常
    INVALID_USER(1001001, "invalid user"),

    //MT5异常
    MT5_INVOKE_ERROR(2001001, "mt5 api invoke error"),
    MT5_DEPOSIT(2001002, "mt5 UserDepositChange error"),
    MT5_BALANCE(2001003, "mt5 balance not enough"),
    MT_RET_ERR_NOTFOUND(2001004, "mt5 order not found"),
    MT5_BALANCE_GET_ERROR(2001005, "mt5 balance get error"),

    //职位操作相关异常
    RANK_APPLICATION_CHECK_INFO_GET_ERROR(3001001, "rank application check info get error");


    private int state;

    private String msg;

    ResultEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public static ResultEnum stateOf(int index) {
        for (ResultEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

}
