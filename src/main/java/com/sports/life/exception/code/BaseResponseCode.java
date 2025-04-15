package com.sports.life.exception.code;

public enum BaseResponseCode implements ResponseCodeInterface{


    SUCCESS(0,"操作成功"),
    SYSTEM_ERROR(5000001,"系统异常请稍后再试"),
    DATA_INSERT_ERR(5000002,"新增失败，请检查输入数据是否正确"),
    REGISTER_ADD_ERR(5000003,"账号已经被注册"),
    REGISTER_INSERT_ERR(5000004,"账号新增失败"),
    IMGS_INSERT_ERR(5000006,"图片新增失败"),
    SELECT_WECHAT_ERR(5000007,"数据异常，请联系管理员"),
    SYSUSER_LOGIN_ERR(5000005,"登录失败，检查重试");

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String msg;
    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMsg() {
        return msg;
    }
}
