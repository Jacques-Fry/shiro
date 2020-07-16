package com.jacques.shiro.handler;

import com.jacques.shiro.utils.WebStatus;

/**
 * @author Jack_YD
 * @create 2019/12/10 13:50
 */
public class CommonException extends RuntimeException {

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

  public CommonException(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public CommonException(WebStatus status) {
    this.code = status.getCode();
    this.msg = status.getMsg();
  }
  public CommonException(WebStatus status, String msg) {
    this.code = status.getCode();
    this.msg = msg;
  }
}
