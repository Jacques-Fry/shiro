package com.jacques.gamelibrary.controller;

import com.jacques.gamelibrary.pojo.GameCategory;
import com.jacques.gamelibrary.service.GameCategoryService;
import com.jacques.shiro.entity.Result;
import com.jacques.shiro.entity.StatusCode;
import com.jacques.shiro.log.sql.SqlLog;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 游戏类型(GameCategory)表控制层
 *
 * @author 花落泪知雨
 * @since 2020-04-21 20:27:59
 */
@Api(tags="游戏类型")
@RestController
@RequestMapping("gameCategory")
public class GameCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private GameCategoryService gameCategoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     */
    @GetMapping("selectOne/{id}")
    public Result selectOne(@PathVariable("id") Integer id) {
        return new Result(true, StatusCode.OK, "查询成功", this.gameCategoryService.queryById(id));
    }


    /**
     * 查询全部数据
     *
     */
    @GetMapping("queryAll")
    public Result queryAll() {
        return new Result(true, StatusCode.OK, "查询成功", this.gameCategoryService.queryAll());
    }

    /**
     * 新增
     * @param gameCategory 实例对象
     */
    @SqlLog(operationName = "新增游戏类型",operation = "gameCategory:upd")
    @RequiresPermissions("gameCategory:add")
    @PostMapping("add")
    public Result add(@RequestBody GameCategory gameCategory) {
        return this.gameCategoryService.insert(gameCategory);
    }

    /**
     * 修改
     * @param gameCategory 实例对象
     */
    @SqlLog(operationName = "修改游戏类型",operation = "gameCategory:upd")
    @RequiresPermissions("gameCategory:upd")
    @PutMapping("upd")
    public Result upd(@RequestBody GameCategory gameCategory) {
        return this.gameCategoryService.update(gameCategory);
    }

    /**
     * 删除
     * @param id 主键
     */
    @SqlLog(operationName = "删除游戏类型",operation = "gameCategory:del")
    @RequiresPermissions("gameCategory:del")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable("id") Integer id) {
        return this.gameCategoryService.deleteById(id);
    }

}