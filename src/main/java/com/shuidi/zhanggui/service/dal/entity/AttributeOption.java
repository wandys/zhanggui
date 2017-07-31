package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 12:30.
 */
public class AttributeOption implements Serializable {

    private static final long serialVersionUID = 1483974749747933070L;
    /**
     * 属性设置id.
     */
    private Long id;

    /**
     * 设置的名称.
     */
    private String name;

    /**
     * 设置取值.
     */
    private String option;

    /**
     * 属性id.
     */
    private Long attributeId;

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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }
}
