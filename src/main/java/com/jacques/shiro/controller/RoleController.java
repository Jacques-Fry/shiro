package com.jacques.shiro.controller;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.pojo.Role;
import com.jacques.shiro.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 花落泪知雨
 * @since 2020/4/26 16:44
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("queryList")
    public Result queryList(@RequestBody(required = false) Role role, @RequestParam int pageNum, @RequestParam int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功", roleService.queryList(role, pageNum, pageSize));
    }
}
