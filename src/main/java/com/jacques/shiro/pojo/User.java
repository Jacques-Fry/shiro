package com.jacques.shiro.pojo;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.jacques.shiro.utils.fileUtil.ExcelAttribute;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:19
 */
public class User implements Serializable,AuthCachePrincipal{
  @ExcelColumn(index = 0)
  @ExcelAttribute(sort = 0)
  private long id;
  @ExcelColumn(index = 1)
  @ExcelAttribute(sort = 1)
  private String username;
  private String password;
  @ExcelColumn(index = 2)
  @ExcelAttribute(sort = 2)
  private String tel;
  /**
   * 账号状态 (0:正常 | 1:已冻结)
   */
  private String status;
  private Integer roleId;
  private Date createTime;

  public User() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "{\"User\":{"
        + "\"id\":\""
        + id + '\"'
        + ",\"username\":\""
        + username + '\"'
        + ",\"password\":\""
        + password + '\"'
        + ",\"tel\":\""
        + tel + '\"'
        + ",\"createTime\":\""
        + createTime + '\"'
        + ",\"status\":\""
        + status + '\"'
        + ",\"roleId\":"
        + roleId
        + "}}";

  }

  @Override
  public String getAuthCacheKey() {
    return null;
  }
}
