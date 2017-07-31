package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe : 属性信息.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 12:25.
 */
public class Attribute implements Serializable {

    private static final long serialVersionUID = -6651006881395079179L;
    /**
     * 属性id.
     */
    private Long id;

    /**
     * 属性名称.
     */
    private String name;

    /**
     * 属性描述信息.
     */
    private String description;

    /**
     * 属性分类id
     */
    private Long categoryId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

