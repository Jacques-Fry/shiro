package com.jacques.shiro.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacques.shiro.dao.PermissionMapper;
import com.jacques.shiro.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:50
 */
@Service
@Transactional
public class PermissionService {

  @Autowired
  private PermissionMapper permissionMapper;

  /**
   * 根据ID查询权限
   * @param roleId
   */
  public HashSet<String> findByRoleId(Integer roleId){
    System.out.println("==============执行了权限查询\n");
    return permissionMapper.findByRoleId(roleId);
  }
  /**
   * 分页条件查询权限
   */
  public PageInfo<Permission> queryList(Permission permission, int pageNum, int pageSize) {
    String orderBy = "";
    PageHelper.startPage(pageNum, pageSize, orderBy);
    List<Permission> permissionList = permissionMapper.queryList(permission, pageNum, pageSize);
    return new PageInfo<>(permissionList);
  }
}
