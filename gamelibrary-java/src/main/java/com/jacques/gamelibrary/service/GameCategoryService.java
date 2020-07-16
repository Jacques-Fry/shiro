package com.jacques.gamelibrary.service;

import com.jacques.gamelibrary.pojo.GameCategory;
import com.jacques.gamelibrary.dao.GameCategoryDao;
import com.jacques.gamelibrary.service.GameCategoryService;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.handler.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 游戏类型(GameCategory)表服务实现类
 *
 * @author 花落泪知雨
 * @since 2020-04-21 20:19:17
 */
@Service
public class GameCategoryService {
    @Resource
    private GameCategoryDao gameCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public GameCategory queryById(Integer id) {
        return this.gameCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<GameCategory> queryAllByLimit(int offset, int limit) {
        return this.gameCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */

    public List<GameCategory> queryAll() {
        return this.gameCategoryDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param gameCategory 实例对象
     * @return 实例对象
     */
    public Result insert(GameCategory gameCategory) {
        if(StringUtils.isBlank(gameCategory.getName()))  return new Result(false,StatusCode.PARAMERROR,"名称不可为空");
        if(this.gameCategoryDao.exsitByName(gameCategory.getName())>0) return new Result(false,StatusCode.PARAMERROR,"名称不可重复");
        if(this.gameCategoryDao.exsitByNickname(gameCategory.getNickname())>0) return new Result(false,StatusCode.PARAMERROR,"别称不可重复");

        //数据初始化
        gameCategory.setFans(0L);
        gameCategory.setHots(0L);
        Date now = new Date();
        gameCategory.setCreateTime(now);
        gameCategory.setUpdateTime(now);

        this.gameCategoryDao.insert(gameCategory);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    /**
     * 修改数据
     *
     * @param gameCategory 实例对象
     * @return 实例对象
     */
    public Result update(GameCategory gameCategory) {
        if (gameCategory.getId() == null || gameCategory.getId() == 0)
            return new Result(false, StatusCode.PARAMERROR, "ID不能为空");
        if (this.gameCategoryDao.exsitById(gameCategory.getId()) <= 0)
            return new Result(false, StatusCode.NOTEXSITS, "此数据已不存在");
        this.gameCategoryDao.update(gameCategory.getId(), gameCategory.getName(), gameCategory.getNickname());
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public Result deleteById(Integer id) {
        if (this.gameCategoryDao.exsitById(id) <= 0) return new Result(false, StatusCode.NOTEXSITS, "此数据已不存在");
        this.gameCategoryDao.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}