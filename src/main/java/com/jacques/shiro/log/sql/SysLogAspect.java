package com.jacques.shiro.log.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jacques.shiro.handler.CommonException;
import com.jacques.shiro.pojo.SysLog;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.service.SysLogService;
import com.jacques.shiro.utils.WebStatus;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jack_YD
 * @create 2020/4/13 8:30 日志拦截器，切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Around("@annotation(log)")
    public Object interceptorAppLogin(ProceedingJoinPoint pj, SqlLog log) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 因为项目的权限控制用的是shiro,所以我这里的可以获取到用户数据
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 获取到被拦截接口上注解的operation 操作 操作名
        String operation = log.operation();
        String operationName = log.operationName();
        // 开始时间戳
        long startTime = System.currentTimeMillis();
        // 开始时间
        Date startDate = new Date();
        // ***继续执行被拦截的接口，记住最后一定要返回这个结果***
        Object proceed = pj.proceed();
        // 获取ip
        String host = request.getRemoteAddr();
        // 登陆时的ip
        String loginHost = SecurityUtils.getSubject().getSession().getHost();
        // ip不一致令牌无效
        if (!StringUtils.equals(host, loginHost)) {
            throw new CommonException(WebStatus.TOKEN_ERROR, "令牌无效");
        }
        // 结束时间
        long endTime = System.currentTimeMillis();
        // 获取到拦截的接口的方法名
        String methodName = pj.getSignature().getDeclaringTypeName() + "." + pj.getSignature().getName();

        // 请求的参数
        Object[] args = pj.getArgs();
        Stream<?> stream = ArrayUtils.isEmpty(args) ? Stream.empty() : Arrays.stream(args);
        List<Object> logArgs = stream
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        String params = null;
        if (logArgs.size() > 0) {
            // 将参数所在的数组转换成json
            params = JSON.toJSONString(args);
            if (params.length() > 65535) {
                params = null;
            }

        }
        // 返回数据(操作结果)
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(proceed);
        String result = null;
        if (jsonObject != null) {
            result = jsonObject.getString("msg");
            if (result.length() > 65535) {
                result = null;
            }
        }

        SysLog sysLog = new SysLog();

        // 操作用户ip地址
        sysLog.setIp(host);
        // 用户数据
        if (user == null) {
            user = (User) SecurityUtils.getSubject().getPrincipal();
        }
        if (user != null) {
            sysLog.setUserId(user.getId() + "");
            sysLog.setUsername(user.getUsername());
        }
        // 方法名
        sysLog.setMethod(methodName);
        // 操作名
        sysLog.setOperation(operation);
        sysLog.setName(operationName);
        // 花费时间
        sysLog.setTime(endTime - startTime);
        // 执行开始时间
        sysLog.setCreateTime(startDate);
        // 被拦截方法的传入的参数值
        sysLog.setParams(params);
        // 操作结果
        sysLog.setResult(result);
        //        System.out.println(JSON.toJSONString(SecurityUtils.getSubject().getSession()));
        //        System.out.println(sysLog.toString());
        // 保存
        sysLogService.saveSysLog(sysLog);
        return proceed;
    }
}
