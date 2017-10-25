package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :商品规格关联表.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 19:41.
 */
public class CommonditySepcificationOption implements Serializable {

    private static final long serialVersionUID = 837696134535779822L;
    /**
     * 唯一自增id.
     */
    private Long id;

    /**
     * 商品id.
     */
    private Long commodityId;

    /**
     * 商品规格设置id.
     */
    private Long specificationOptionId;
    /**
     * 商品规格.
     */
    private Long specificationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getSpecificationOptionId() {
        return specificationOptionId;
    }

    public void setSpecificationOptionId(Long specificationOptionId) {
        this.specificationOptionId = specificationOptionId;
    }
}
