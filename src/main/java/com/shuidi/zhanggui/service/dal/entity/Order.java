package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.Date;
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
public class Order implements Serializable {


    private static final long serialVersionUID = -1017246049820315305L;
    /**
     * 自增id.
     */
    private Long id;

    /**
     * 订单编号.
     */
    private String no;

    /**
     * 店铺id.
     */
    private Long shopId;

    /**
     * 订单总价.
     */
    private Long money;
    /**
     * 折扣金额.
     */
    private Long discountMoney;

    /**
     * 折扣明细.
     */
    private String discountDetail;

    /**
     * 总数量.
     */
    private Integer amount;

    /**
     * 订单状态.
     */
    private String orderStatus;

    /**
     * 支付状态.
     */
    private String payStatus;

    /**
     * 支付方式.
     */
    private String payWay;

    /**
     * 商品详情.
     */
    private String goodsDeatil;

    private List<OrderGoods> orderGoods;

    private Date createTime;

    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Long discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getGoodsDeatil() {
        return goodsDeatil;
    }

    public void setGoodsDeatil(String goodsDeatil) {
        this.goodsDeatil = goodsDeatil;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
