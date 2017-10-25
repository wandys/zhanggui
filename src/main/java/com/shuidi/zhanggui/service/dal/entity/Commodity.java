package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Describe : 商品表.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 12:20.
 */
public class Commodity implements Serializable {

    private static final long serialVersionUID = 2619644122833611050L;

    /**
     * 商品id.
     */
    private Long id;

    /**
     * 商品编号.
     */
    private String sku;

    /**
     * 商品名称.
     */
    private String name;

    /**
     * 商品描述信息.
     */
    private String description;

    /**
     * 商品id.
     */
    private Long goodsId;

    private Goods goods;

    /**
     *  商品的属性列表.
     */
    private List<CommmodityAttributeOption> commmodityAttributeOptions;

    /**
     *  商品的规格列表.
     */
    private List<CommonditySepcificationOption> commonditySepcificationOptions;

    /**
     * 价格id.
     */
    private Long priceId;

    /**
     * 成本价.
     */
    private Integer costPrice;
    /**
     * 售价.
     */
    private Integer sellingPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
