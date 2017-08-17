package com.wl.college.enums;

/**
 * 权限
 * Created by DIY on 2017/6/16.
 */
public class OperationType {
    //客户
    public static final String ACCOUNT_GET = "account:get";
    public static final String ACCOUNT_UPDATE_MTUSER = "account:update_mtuser";
    public static final String ACCOUNT_UPDATE = "account:update";
    public static final String ACCOUNT_TREE = "account:tree";
    public static final String ACCOUNT_UPDATE_PASSWORD = "account:update_password";
    public static final String ACCOUNT_UPDATE_MT_PASSWORD = "account:update_mt_password";
    public static final String ACCOUNT_GET_ACCOUNY = "account:get_account";
    public static final String ACCOUNT_CHECK_IDCARD = "account:check_idcard";
    public static final String ACCOUNT_CHECK_MT_PASSWORD = "account:check_mt_password";
    public static final String ACCOUNT_GET_RANK = "account:get_rank";
    public static final String ACCOUNT_CHECK_BANKCARD = "account:check_bankcard";
    public static final String ACCOUNT_CHECK_BANKCARD_GET = "account:check_bankcard_get";
    public static final String ACCOUNT_IDCARD_GET = "account:idcard_get";
    public static final String ACCOUNT_GET_EXCEL = "account:get_excel";
    public static final String ACCOUNT_CHART = "account:chart";
    public static final String ACCOUNT_COUNT = "account:count";
    //杠杆申请
    public static final String LEVERAGE_APPLICATION_UPDATE = "leverageApplication:update";
    public static final String LEVERAGE_APPLICATION_GET = "leverageApplication:get";
    public static final String DEALPARAM_UPDATE = "dealparam:update";
    public static final String DEALPARAM_GET = "dealparam:get";
    //
    public static final String LEVERAGE_ADD = "leverage:add";
    public static final String LEVERAGE_GET = "leverage:get";
    public static final String LEVERAGE_DELETE = "leverage:delete";
    public static final String LEVERAGE_UPDATE = "dealparam:update";
    public static final String RANK_APPLICATION_UPDATE = "rankApplication:update";
    public static final String RANK_APPLICATION_GET = "rankApplication:get";
    public static final String RANK_UPDATE = "rank:update";
    public static final String RANK_ADD = "rank:add";
    public static final String RANK_DELETE = "rank:delete";
    public static final String RANK_AMDIN_GET = "rank:admin_get";
    public static final String RANK_GET_BY_ID = "rank:get_by_id";
    public static final String DEPOSITS_USER_POST = "deposits:user_post";
    public static final String DEPOSITS_GET = "deposits:get";
    public static final String DEPOSITS_QUERY = "deposits:query";
    public static final String DEPOSITS_TODAY_DEPOSIT_GET = "deposits:today_deposit_get";
    public static final String WITHDRAW_UPDATE = "withdraw:update";
    public static final String WITHDRAW_GET = "withdraw:get";
    public static final String WITHDRAW_EXCEL = "withdraw:excel";
    public static final String WITHDRAW_TODAY_WITHDRAW_GET = "withdraw:today_withdraw_get";
    public static final String WITHDRAW_QUERY = "withdraw:query";


    //commission
    public static final String COMMISSIONS_LIST = "commissions:list";

    //user
    public static final String USER_CREATE = "user:create";
    public static final String USER_DELETE = "user:delete";
    public static final String USER_UPDATE = "user:update";
    public static final String USER_VIEW = "user:view";

    //role
    public static final String ROLE_CREATE = "role:create";
    public static final String ROLE_DELETE = "role:delete";
    public static final String ROLE_UPDATE = "role:update";
    public static final String ROLE_VIEW = "role:view";

    //permission
    public static final String PERMISSION_CREATE = "permission:create";
    public static final String PERMISSION_DELETE = "permission:delete";
    public static final String PERMISSION_UPDATE = "permission:update";
    public static final String PERMISSION_VIEW = "permission:view";


    //session
    public static final String SESSION_ALL = "session:*";

    //data log
    public static final String ACCOUNT_LOG = "AccountLog:view";
    public static final String USER_LOG = "userLog:view";

    public static final String MT5_DEALS_GET = "mt5:deals_get";

    public static final String UPGRADE_INFO_GET = "upgrade:info_get";
}
