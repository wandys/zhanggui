package com.shuidi.zhanggui.service.dal.entity;

import java.io.Serializable;

/**
 * Created by wandy on 17-8-29.
 */
public class CountryArea implements Serializable {

  private static final long serialVersionUID = -8342559443193229416L;

  private Long id;

  private String areaNo;

  private String name;

  private String pNo;

  private String pInfos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAreaNo() {
    return areaNo;
  }

  public void setAreaNo(String areaNo) {
    this.areaNo = areaNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getpNo() {
    return pNo;
  }

  public void setpNo(String pNo) {
    this.pNo = pNo;
  }

  public String getpInfos() {
    return pInfos;
  }

  public void setpInfos(String pInfos) {
    this.pInfos = pInfos;
  }
}
