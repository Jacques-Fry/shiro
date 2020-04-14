package com.jacques.shiro.pojo;

import java.util.Date;

/**
 * @author Jack_YD
 * @create 2020/4/13 8:45
 */
public class SysLog {
    private long id;
    private String name;
    private String UserId;
    private String username;
    private String operation;
    private long time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;

    public SysLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "{\"SysLog\":{"
                + "\"id\":"
                + id
                + ",\"name\":\""
                + name + '\"'
                + ",\"UserId\":"
                + UserId
                + ",\"username\":\""
                + username + '\"'
                + ",\"operation\":\""
                + operation + '\"'
                + ",\"time\":"
                + time
                + ",\"method\":\""
                + method + '\"'
                + ",\"params\":\""
                + params + '\"'
                + ",\"ip\":\""
                + ip + '\"'
                + ",\"createTime\":\""
                + createTime + '\"'
                + "}}";

    }
}
