package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Describe :规格表信息.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 19:33.
 */
public class Specifications implements Serializable {

    private static final long serialVersionUID = -1991285353348040004L;
    /**
     * 自增id.
     */
    private Long id;

    /**
     * 规格名称.
     */
    private String name;

    /**
     * 规格分组id.
     */
    private Long specGroupId;

    /**
     * 规格组信息.
     */
    private SpecificationGroup specificationGroup;

    /**
     * 分类id.
     */
    private Long categoryId;
    /**
     * 规格设置信息.
     */
    private List<SpecificationOption> specificationOptions;

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

    public Long getSpecGroupId() {
        return specGroupId;
    }

    public void setSpecGroupId(Long specGroupId) {
        this.specGroupId = specGroupId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public SpecificationGroup getSpecificationGroup() {
        return specificationGroup;
    }

    public void setSpecificationGroup(SpecificationGroup specificationGroup) {
        this.specificationGroup = specificationGroup;
    }

    public List<SpecificationOption> getSpecificationOptions() {
        return specificationOptions;
    }

    public void setSpecificationOptions(List<SpecificationOption> specificationOptions) {
        this.specificationOptions = specificationOptions;
    }
}
