package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 19:38.
 */
public class SpecificationOption implements Serializable {

    private static final long serialVersionUID = 3252767157603080408L;
    /**
     * 自增id.
     */
    private Long id;

    /**
     * 规格设置名称.
     */
    private String name;

    /**
     * 规格设置值.
     */
    private String option;

    /**
     * 规格id.
     */
    private Long specificationId;

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

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }
}
