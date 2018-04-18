package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Describe :货品表.
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 11:18.
 */
public class OrderGoods implements Serializable {


  private static final long serialVersionUID = 5885956947930568327L;
  /**
   * 自增id.
   */
  private Long id;

  /**
   * 订单编号.
   */
  private String no;

  /**
   * 商品名称.
   */
  private String name;

  /**
   * 货品相关的描述信息.
   */
  private String description;

  /**
   * 商品总价.
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
   * 单位.
   */
  private String unit;

  /**
   * 主图.
   */
  private String mainImge;

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

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getMainImge() {
    return mainImge;
  }

  public void setMainImge(String mainImge) {
    this.mainImge = mainImge;
  }
}
