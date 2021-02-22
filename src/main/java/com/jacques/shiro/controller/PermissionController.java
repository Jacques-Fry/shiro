package com.jacques.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.pojo.Permission;
import com.jacques.shiro.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 花落泪知雨
 * @since 2020/4/26 16:44
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @PostMapping("queryList")
    public Result<PageInfo<Permission>> queryList(@RequestBody(required = false) Permission permission, @RequestParam int pageNum, @RequestParam int pageSize) {
        return new Result<>("查询成功", permissionService.queryList(permission, pageNum, pageSize));
    }

    @GetMapping("details/{id}")
    public Result<Permission> queryList(@PathVariable(name = "id") int id) {
        return new Result<>("查询成功", permissionService.findById(id));
    }
}
