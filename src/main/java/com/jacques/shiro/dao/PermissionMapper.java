package com.jacques.shiro.dao;

import com.jacques.shiro.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:27
 */
@Mapper
@Component
public interface PermissionMapper {

  HashSet<String> findByRoleId(@Param("roleId") Integer roleId);

  List<Permission> queryList(@Param("permission") Permission permission, int pageNum, int pageSize);

  Permission findById(@Param("id") int id);
}
