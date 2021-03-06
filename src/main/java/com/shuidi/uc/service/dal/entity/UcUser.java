package com.shuidi.uc.service.dal.entity;

import com.shuidi.uc.commons.enums.Status;

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
    //状态
    private Status status;
    //状态
    private String phone;
    //密码
    private String password;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //最后登录时间
    private Date lastLoginTime;

    private String salt;

    private String shaKey;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getShaKey() {
        return shaKey;
    }

    public void setShaKey(String shaKey) {
        this.shaKey = shaKey;
    }
}
