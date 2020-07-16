package com.jacques.shiro.dao;

import com.jacques.shiro.pojo.Role;
import com.jacques.shiro.pojo.User;
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
public interface RoleDao {

  @Select("SELECT " +
      "  r.`name`" +
      "FROM" +
      "  `role` r " +
      "WHERE r.id=#{id}")
  HashSet<String> findById(@Param("id") Integer id);

  @Select("SELECT " +
          "`id` ," +
          "`name`," +
          "`nickname`" +
          "FROM `role` " +
          "WHERE `name` LIKE IFNULL(CONCAT('%',#{role.name},'%'),'%') " +
          "AND `nickname` LIKE IFNULL(CONCAT('%',#{role.nickname},'%'),'%') ")
  List<Role> queryList(@Param("role") Role role, int pageNum, int pageSize);
}
