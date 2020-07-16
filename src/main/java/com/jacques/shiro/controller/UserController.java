package com.jacques.shiro.controller;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.log.sql.SqlLog;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.service.UserService;
import com.jacques.shiro.utils.fileUtil.ExcelExportUtil;
import com.jacques.shiro.utils.fileUtil.ExcelImportUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


/**
 * @author Jack_YD
 * @create 2019/12/23 16:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @SqlLog(operationName = "登录", operation = "user:login")
    @GetMapping("/login")
    public Result login(String username, String password) {
        return userService.login(username, password);
    }

    @SqlLog(operationName = "退出登录", operation = "user:logout")
    @GetMapping("/logout")
    public Result logout() {
        Subject lvSubject = SecurityUtils.getSubject();
        lvSubject.logout();
        return new Result(true, StatusCode.OK, "退出成功");
    }

    @PostMapping("queryList")
    public Result queryList(@RequestBody(required = false) User user, @RequestParam int pageNum, @RequestParam int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功", userService.queryList(user, pageNum, pageSize));
    }


    @SqlLog(operationName = "访问用户upd", operation = "user:upd")
    @RequiresPermissions("user:upd")
    @GetMapping("upd")
    public Result upd() {
        return new Result(true, StatusCode.OK, "访问upd成功");
    }

    //  @RequiresRoles("system")
    @SqlLog(operationName = "导入用户数据", operation = "user:import")
    @PostMapping("import")
    public Result importUser(MultipartFile file) throws IOException {
        if (file == null) {
            return new Result(false, StatusCode.PARAMERROR, "未传入文件");
        }
        List<User> userList = new ExcelImportUtil<User>(User.class).readExcel(file.getInputStream(), 1, 0);
        userService.saveUserList(userList);
        return new Result(true, StatusCode.OK, "导入成功");
    }

    @SqlLog(operationName = "导出用户数据", operation = "user:export")
    @GetMapping("export")
    public void exportUser(HttpServletResponse response) throws Exception {
        List<User> users = userService.findAll();
        //加载模板
        Resource resource = new ClassPathResource("excel-template/user.xlsx");
        FileInputStream fis = new FileInputStream(resource.getFile());
        //通过工具类下载
        new ExcelExportUtil<User>(User.class, 1, 1).export(response, fis, users, "用户表数据.xlsx");

    }
}
