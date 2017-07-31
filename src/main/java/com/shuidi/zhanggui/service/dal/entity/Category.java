package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :分类信息.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 12:35.
 */
public class Category implements Serializable {

    private static final long serialVersionUID = -2213346605338956059L;
    /**
     * 分类id.
     */
    private Long id;

    /**
     * 分类编号.
     */
    private String categoryNo;

    /**
     * 分类名称.
     */
    private String categroyName;

    /**
     * 分类描述信息.
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategroyName() {
        return categroyName;
    }

    public void setCategroyName(String categroyName) {
        this.categroyName = categroyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
