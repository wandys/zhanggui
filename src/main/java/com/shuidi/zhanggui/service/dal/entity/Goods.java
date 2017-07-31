package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Describe :货品表.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 11:18.
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = -5897233932598317904L;

    /**
     * 自增id.
     */
    private Long id;

    /**
     * 货品名称.
     */
    private String goodsName;

    /**
     * 货品编号，等同于SPU.
     */
    private String goodsNo;

    /**
     * 货品相关的描述信息.
     */
    private String description;

    /**
     * 货品明细.
     */
    private String detail;

    /**
     * 货品分类id.
     */
    private String categoryId;

    /**
     * 品牌id.
     */
    private Long brandId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
