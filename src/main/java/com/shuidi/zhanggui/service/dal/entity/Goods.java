package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.List;

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
    private String name;

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
    private Long categoryId;

    private Category category;

    /**
     * 品牌id.
     */
    private Long brandId;

    private Brand brand;

    private List<Commodity> commodities;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
