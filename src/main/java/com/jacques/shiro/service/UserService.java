package com.jacques.shiro.service;

import com.jacques.shiro.dao.UserDao;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:49
 */
@Transactional
@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Value("${custom.md5Salt}")
  private String md5Salt;

  public User findByUsername(String username){
    return userDao.findByUsername(username);
  }

  public User findById(String id){
    return userDao.findById(id);
  }

  public Result login(String username,String password){
    try {
      //构造登陆令牌
      UsernamePasswordToken upToken = new UsernamePasswordToken(username, new Md5Hash(password,md5Salt,3).toString());
      //获取subject
      Subject subject = SecurityUtils.getSubject();

      String sid= (String) subject.getSession().getId();
      //调用登陆
      subject.login(upToken);

      return new Result(true, StatusCode.OK, "登陆成功: ",sid);
    } catch (Exception e) {
      return new Result(true, StatusCode.OK, "用户名或密码错误");
    }
  }

  public void saveUserList(List<User> user){
    for (User u : user) {
      u.setPassword(new Md5Hash(u.getPassword(),md5Salt,3).toString());
      u.setStatus("0");
      u.setCreateTime(new Date());
      userDao.saveUser(u);
    }
  }
}
