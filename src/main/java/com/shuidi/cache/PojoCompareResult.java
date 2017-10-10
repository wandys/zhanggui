package com.shuidi.cache;

public class PojoCompareResult {
  //操作
  private PojoCompareUtil.Operate operate;
  //字段名
  private String fieldName;
  //旧值
  private Object oldValue;
  //新值
  private Object newValue;

  public PojoCompareUtil.Operate getOperate() {
    return operate;
  }

  public void setOperate(PojoCompareUtil.Operate operate) {
    this.operate = operate;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public Object getOldValue() {
    return oldValue;
  }

  public void setOldValue(Object oldValue) {
    this.oldValue = oldValue;
  }

  public Object getNewValue() {
    return newValue;
  }

  public void setNewValue(Object newValue) {
    this.newValue = newValue;
  }
}
