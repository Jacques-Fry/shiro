package com.jacques.shiro.log.sql;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author Jack_YD
 * @create 2020/4/13 8:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Order(Ordered.HIGHEST_PRECEDENCE)
@Documented
public @interface SqlLog {
    //操作
    String operation() default "";
    //操作名
    String operationName() default "";
}
