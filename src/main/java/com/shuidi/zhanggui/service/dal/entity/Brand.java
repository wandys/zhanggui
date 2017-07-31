package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe : 品牌表.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 10:42.
 */
public class Brand implements Serializable {

    private static final long serialVersionUID = 5974083210164811354L;

    /**
     * 自增id.
     */
    private Long id;

    /**
     * 品牌编号.
     */
    private String brandNo;

    /**
     * 品牌名称.
     */
    private String branName;

    /**
     * 品牌相关描述.
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    public String getBranName() {
        return branName;
    }

    public void setBranName(String branName) {
        this.branName = branName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
