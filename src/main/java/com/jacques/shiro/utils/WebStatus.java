package com.jacques.shiro.utils;

public enum WebStatus {
    OK (200,"调用成功"),//成功
    ERROR (500,"程序未知错误"),//程序未知错误

    REPETITIVE_OPERATION (3003,"重复操作"),//重复操作

    PARAM_ERROR (4000,"参数错误"),//参数错误
    NOTEXSITS(4004,"数据不存在"),//数据不存在
    FILE_UPLOAD_ERROR(4021,"文件上传失败"),//文件上传失败

    REMOTE_ERROR(5021,"远程调用失败"),//远程调用失败

    TOKENERROR(6000,"token过期或无效/未登录"),// token过期或无效/未登录
    USERERROR(6001,"用户名或密码错误"),// 用户名或密码错误
    FREEZE(6002,"账号被冻结"),// 账号被冻结
    SYSERROR(6003,"没有权限");// 没有权限

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    WebStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
