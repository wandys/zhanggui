package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :规格分组信息.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 19:36.
 */
public class SpecificationGroup implements Serializable {

    private static final long serialVersionUID = 435492063305418460L;
    /**
     * 自增id.
     */
    private Long id;

    /**
     * 规格分组名称.
     */
    private String name;

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
}
