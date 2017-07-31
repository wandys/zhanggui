package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 12:33.
 */
public class CommmodityAttributeOption implements Serializable{

    private static final long serialVersionUID = 8491109535266845170L;
    /**
     * 自增id.
     */
    private Long id;

    /**
     * 商品id.
     */
    private Long CommodityId;

    /**
     * 属性设置id.
     */
    private Long attributeOptionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommodityId() {
        return CommodityId;
    }

    public void setCommodityId(Long commodityId) {
        CommodityId = commodityId;
    }

    public Long getAttributeOptionId() {
        return attributeOptionId;
    }

    public void setAttributeOptionId(Long attributeOptionId) {
        this.attributeOptionId = attributeOptionId;
    }
}