package com.jacques.shiro.handler;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.utils.WebStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Jack_YD
 * @create 2019/8/27 16:07
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LogManager.getLogger(com.jacques.shiro.handler.CommonExceptionHandler.class);


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        return new Result<>(false,400,"缺少请求参数");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return new Result<>(false,400,"参数解析失败");
    }


    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<String> noHandlerFoundException(NoHandlerFoundException e) {
        logger.error("Not Found", e);
        return new Result<>(false,404,"API不存在");
    }


    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return new Result<>(false,405,"不支持当前请求方法");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<String> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型", e);
        return new Result<>(false,415,"不支持当前媒体类型");
    }


    /**
     * shiro异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {AuthorizationException.class})
    public Result<String> authorizationException(AuthorizationException e) {
        logger.error(e);
        return new Result<>(WebStatus.SYS_ERROR, "没有权限");
    }
    @ExceptionHandler(value = {UnauthenticatedException.class})
    public Result<String> unauthenticatedException(AuthorizationException e) {
        logger.error(e);
        return new Result<>(WebStatus.SYS_ERROR, "未登录或登陆失效");
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {CommonException.class})
    public Result<String> commonException(CommonException e) {
        return new Result<>(false, e.getCode(), e.getMsg());
    }

    /**
     * 其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public Result<String> exception(Exception e) {
        logger.error("ExceptionTest Exception:", e);
        return new Result<>(WebStatus.ERROR, "系统繁忙,请稍后再试");
    }

}
