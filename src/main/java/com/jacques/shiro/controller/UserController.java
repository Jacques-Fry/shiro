package com.jacques.shiro.controller;

import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.service.UserService;
import com.jacques.shiro.utils.fileUtil.ExcelImportUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
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

  @GetMapping("/login")
  public Result login(String username, String password) {
    return userService.login(username, password);
  }


  //  @RequiresRoles() 访问此方法必备角色
  //  @RequiresPermissions() 访问此方法必备权限
  @RequiresPermissions("user:home")
  @GetMapping("home")
  public Result home() {
    return new Result(true, StatusCode.OK, "访问home成功");
  }

  @RequiresPermissions("user:upd")
  @GetMapping("upd")
  public Result upd() {
    return new Result(true, StatusCode.OK, "访问upd成功");
  }

  //  @RequiresRoles("system")
  @PostMapping("import")
  public Result importUser( MultipartFile file) throws IOException {
    if (file == null) {
      return new Result(false, StatusCode.PARAMERROR, "未传入文件");
    }
    List<User> userList = new ExcelImportUtil<User>(User.class).readExcel(file.getInputStream(), 1, 0);
    userService.saveUserList(userList);
    return new Result(true, StatusCode.OK, "导入成功");
  }
}
