package com.jacques.shiro.dao;

import com.jacques.shiro.pojo.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Jack_YD
 * @create 2020/4/13 9:04
 */
@Mapper
@Component
public interface SysLogDao {

    @Insert("INSERT INTO `sys_log`(" +
            "`id`,"+
            "`name`," +
            "`user_id`," +
            "`username`," +
            "`operation`," +
            "`time`," +
            "`method`," +
            "`params`," +
            "`result`," +
            "`ip`," +
            "`create_time`" +
            ")" +
            "VALUES" +
            "(" +
            "#{sysLog.id}," +
            "#{sysLog.name}," +
            "#{sysLog.userId}," +
            "#{sysLog.username}," +
            "#{sysLog.operation}," +
            "#{sysLog.time}," +
            "#{sysLog.method}," +
            "#{sysLog.params}," +
            "#{sysLog.result}," +
            "#{sysLog.ip}," +
            "#{sysLog.createTime}" +
            ");")
    void saveSysLog(@Param("sysLog") SysLog sysLog);
    
    @Select("SELECT" +
            "`id` ," +
            "`name` ," +
            "`user_id` ," +
            "`username` ," +
            "`operation` ," +
            "`time` ," +
            "`method` ," +
            "`params` ," +
            "`result` ," +
            "`ip` ," +
            "`create_time` " +
            "FROM `sys_log`"+
            "WHERE `name` LIKE IFNULL(CONCAT('%',#{sysLog.name},'%'),'%') " +
            "AND `username` LIKE IFNULL(CONCAT('%',#{sysLog.username},'%'),'%') "+
            "AND `ip` LIKE IFNULL(CONCAT('%',#{sysLog.ip},'%'),'%') ")
    List<SysLog> queryList(@Param("sysLog") SysLog sysLog, int pageNum, int pageSize);
}
