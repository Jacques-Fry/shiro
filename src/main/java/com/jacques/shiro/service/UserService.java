package com.jacques.shiro.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacques.shiro.dao.UserDao;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.handler.CommonException;
import com.jacques.shiro.pojo.User;
import com.jacques.shiro.utils.WebStatus;
import org.apache.commons.lang3.StringUtils;
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
@Service
public class UserService {

  @Autowired private UserDao userDao;

  @Value("${custom.md5Salt}")
  private String md5Salt;

  /**
   * 通过username获取用户数据
   *
   * @param username
   */
  public User findByUsername(String username) {
    return userDao.findByUsername(username);
  }

  /**
   * 通过id获取用户数据
   *
   * @param id
   */
  public User findById(long id) {
    return userDao.findById(id);
  }

  /**
   * 普通登陆方式
   *
   * @param username
   * @param password
   * @return
   */
  public Result<String> login(String username, String password) {
    try {
      // 构造登陆令牌
      UsernamePasswordToken upToken =
          new UsernamePasswordToken(username, new Md5Hash(password, md5Salt, 3).toString());
      // 获取subject
      Subject subject = SecurityUtils.getSubject();

      String sid = (String) subject.getSession().getId();
      // 调用登陆
      subject.login(upToken);

      return new Result<>("登陆成功", sid);
    } catch (Exception e) {
      return new Result<>(WebStatus.USER_ERROR, "用户名或密码错误");
    }
  }

  /** 分页查询用户数据 */
  public PageInfo<User> queryList(User user, int pageNum, int pageSize) {
    String orderBy = "";
    PageHelper.startPage(pageNum, pageSize, orderBy);
    List<User> userList = userDao.queryList(user, pageNum, pageSize);
    return new PageInfo<>(userList);
  }

  /** 查询登陆的用户信息 */
  public User getUser() {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    return this.selectDetails(user.getId());
  }

  /** 获取用户详情数据 */
  public User selectDetails(long id) {
    // 验证ID
    verifyId(id);
    return userDao.selectDetails(id);
  }

  /**
   * 导入用户
   *
   * @param user
   */
  @Transactional
  public void saveUserList(List<User> user) {
    long count = 2;
    // 由于抛出自定义异常事务失效，所以先执行验证
    for (User u : user) {
      //      if (StringUtils.isBlank(u.getId()))
      //        throw new CommonException(StatusCode.OK, "有数据的ID值为空，导入失败，在第" + count + "行");
      if (userDao.countById(u.getId()) > 0) {
        throw new CommonException(
            WebStatus.PARAM_ERROR, "有ID被使用，导入失败，ID值为:" + u.getId() + "，在第" + count + "行");
      }
      if (StringUtils.isBlank(u.getUsername())) {
        throw new CommonException(WebStatus.PARAM_ERROR, "有数据的用户名为空，导入失败，在第" + count + "行");
      }
      if (userDao.countByUsername(u.getUsername()) > 0) {
        throw new CommonException(
            WebStatus.PARAM_ERROR, "有用户名被使用，导入失败，用户名为:" + u.getUsername() + "，在第" + count + "行");
      }
      if (StringUtils.isBlank(u.getTel())) {
        throw new CommonException(WebStatus.PARAM_ERROR, "有数据的手机号码为空，导入失败，在第" + count + "行");
      }
      if (userDao.countByTel(u.getTel()) > 0) {
        throw new CommonException(
            WebStatus.PARAM_ERROR, "有手机号码被使用，导入失败，手机号为:" + u.getTel() + "，在第" + count + "行");
      }
      count++;
    }

    for (User u : user) {
      u.setPassword(new Md5Hash("123456", md5Salt, 3).toString());
      u.setStatus("0");
      u.setCreateTime(new Date());
      u.setRoleId(9);
      userDao.saveUser(u);
    }
  }

  /** 查询所有用户 */
  public List<User> findAll() {
    return userDao.findAll();
  }

  /** ID是否存在 */
  public void verifyId(long id) {
    if (id == 0) {
      throw new CommonException(WebStatus.PARAM_ERROR, "ID不能为空");
    }
    if (!userDao.verifyId(id)) {
      throw new CommonException(WebStatus.NOT_EXISTS, "ID不存在");
    }
  }
}
