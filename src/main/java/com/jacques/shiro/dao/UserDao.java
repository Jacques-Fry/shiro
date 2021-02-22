package com.jacques.shiro.dao;

import com.jacques.shiro.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jack_YD
 * @create 2019/12/23 14:27
 */
@Mapper
@Component
public interface UserDao {

    @Select("SELECT " +
            "  `id`," +
            "  `password`," +
            "  `status`, " +
            "  `role_id` " +
            "FROM" +
            "  `user`  " +
            "WHERE `username` = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("SELECT " +
            "  `role_id`, " +
            "  `status` " +
            "FROM" +
            "  `user`  " +
            "WHERE `id` = #{id}")
    User findById(@Param("id") long id);

    @Select("SELECT " +
            "  `id`, " +
            "  `username`, " +
            "  `password`, " +
            "  `tel`, " +
            "  `create_time`, " +
            "  `status`, " +
            "  `role_id` " +
            "FROM" +
            "  `user`  ")
    List<User> findAll();


    @Select("SELECT " +
            "`id` , " +
            "`username`, " +
            "`tel` , " +
            "`create_time` , " +
            "`status` , " +
            "`role_id`" +
            "FROM `user`" +
            "WHERE username LIKE IFNULL(CONCAT('%',#{user.username},'%'),'%')" +
            "AND tel LIKE IFNULL(CONCAT('%',#{user.tel},'%'),'%')" +
            "AND role_id LIKE IFNULL(CONCAT('%',#{user.roleId},'%'),'%')")
    List<User> queryList(@Param("user") User user,int pageNum,int pageSize);

    @Select("SELECT " +
            "  count(`id`) " +
            "FROM" +
            "  `user`  " +
            "WHERE `id` = #{id}")
    Integer countById(@Param("id") long id);

    @Select("SELECT " +
            "  count(`id`) " +
            "FROM" +
            "  `user`  " +
            "WHERE `tel` = #{tel}")
    Integer countByTel(@Param("tel") String tel);

    @Select("SELECT " +
            "  count(`id`) " +
            "FROM" +
            "  `user`  " +
            "WHERE `username` = #{username}")
    Integer countByUsername(@Param("username") String username);


    @Insert("INSERT INTO `user` ( " +
            "  `id`, " +
            "  `username`, " +
            "  `password`, " +
            "  `tel`, " +
            "  `create_time`, " +
            "  `status`, " +
            "  `role_id` " +
            ")  " +
            "VALUES " +
            "  ( " +
            "    #{user.id}, " +
            "    #{user.username}, " +
            "    #{user.password}, " +
            "    #{user.tel}, " +
            "    #{user.createTime}, " +
            "    #{user.status}, " +
            "    #{user.roleId} " +
            "  ) ; ")
    void saveUser(@Param("user") User user);

    User selectDetails(@Param("id") long id);

    boolean verifyId(@Param("id") long id);
}
