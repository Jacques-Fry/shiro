package com.jacques.shiro.controller;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.pojo.SysLog;
import com.jacques.shiro.service.SysLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 花落泪知雨
 * @since 2020/4/26 17:51
 */
@RestController
@RequestMapping("syslog")
public class SysLogController {

    @Resource
    private SysLogService sysLogService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody(required = false) SysLog sysLog, @RequestParam int pageNum, @RequestParam int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功", sysLogService.queryList(sysLog, pageNum, pageSize));
    }
}
