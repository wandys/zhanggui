package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户中心的用户基础信息.
 *
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 17:16.
 */
public class UcUser implements Serializable {

    private Long id;
    //用户名
    private String name;
    //密码
    private String password;
    //注册时间
    private Date regTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //最后登录时间
    private Date lastLoginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
