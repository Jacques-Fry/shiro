package com.jacques.gamelibrary.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 游戏类型(GameCategory)实体类
 *
 * @author 花落泪知雨
 * @since 2020-04-21 20:19:15
 */
public class GameCategory implements Serializable {
    private static final long serialVersionUID = 289909737385160275L;
    /**
    * 类型编号
    */
    private Integer id;
    /**
    * 类型名称
    */
    private String name;
    /**
    * 类型别称
    */
    private String nickname;
    /**
     * 类型logo
     */
    private String logo;
    /**
    * 热度
    */
    private Long hots;
    /**
    * 关注人数
    */
    private Long fans;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getHots() {
        return hots;
    }

    public void setHots(Long hots) {
        this.hots = hots;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}