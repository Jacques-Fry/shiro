package com.jacques.shiro.handler;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.utils.WebStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jack_YD
 * @create 2019/8/27 16:07
 */
@RestControllerAdvice
public class CommonExceptionHandler {

  private static final Logger logger = LogManager.getLogger(com.jacques.shiro.handler.CommonExceptionHandler.class);

  @ExceptionHandler(value = {AuthorizationException.class})
  public Result authorizationException(AuthorizationException e) {
    return new Result(WebStatus.SYSERROR,"没有权限");
  }

  @ExceptionHandler(value = {CommonException.class})
  public Result commonException(CommonException e) {
    return new Result(false, e.getCode(),e.getMsg());
  }

  @ExceptionHandler(value = {Exception.class})
  public Result exception(Exception e) {
    logger.error("ExceptionTest Exception:",e);
    return new Result(WebStatus.ERROR,"系统繁忙,请稍后再试");
  }

}
