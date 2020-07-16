package com.jacques.gamelibrary.dao;

import com.jacques.gamelibrary.pojo.GameCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 游戏类型(GameCategory)表数据库访问层
 *
 * @author 花落泪知雨
 * @since 2020-04-21 20:19:16
 */
@Mapper
public interface GameCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select id,name,nickname,hots,fans,create_time,update_time from game_category where id=#{id}")
    GameCategory queryById(@Param("id") Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select id,name,nickname,hots,fans,create_time,update_time from game_category limit #{offset} , #{limit}")
    List<GameCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询全部
     *
     * @return 对象列表
     */
    @Select("select id,name,nickname,hots,fans,create_time,update_time from game_category")
    List<GameCategory> queryAll();

    /**
     * 新增数据
     *
     * @param gameCategory 实例对象
     * @return 影响行数
     */
    @Insert("insert into `game_category`( " +
            "`name`, " +
            "`nickname`, " +
            "`logo`, " +
            "`hots`, " +
            "`fans`, " +
            "`create_time`, " +
            "`update_time`) " +
            "VALUES ( " +
            "#{gameCategory.name}, " +
            "#{gameCategory.nickname}, " +
            "#{gameCategory.logo}, " +
            "#{gameCategory.hots}, " +
            "#{gameCategory.fans}, " +
            "#{gameCategory.createTime}, " +
            "#{gameCategory.updateTime} " +
            ")")
    void insert(@Param("gameCategory") GameCategory gameCategory);

    /**
     * 验证id、name、nickname
     */
    @Select("select count(1) from game_category where id=#{id}")
    int exsitById(@Param("id") Integer id);
    @Select("select count(1) from game_category where name=#{name}")
    int exsitByName(@Param("name") String name);
    @Select("select count(1) from game_category where nickname=#{nickname}")
    int exsitByNickname(@Param("nickname") String nickname);

    /**
     * 修改数据
     *
     * @return 影响行数
     */
    @Update("update game_category set name=#{name} , nickname=#{nickname} where id=#{id}")
    void update(@Param("id") Integer id, @Param("name") String name, @Param("nickname") String nickname);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from game_category where id=#{id}")
    void deleteById(@Param("id") Integer id);

}