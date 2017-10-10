/*
 * Created by wandy on 2017-09-19.
 */

package com.shuidi.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shuidi.commons.exception.ServiceException;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2017-09-19
 */
public class PojoCompareUtil {

  private CompareFeature[] compareFeatures;

  public PojoCompareUtil() {
  }

  public PojoCompareUtil(CompareFeature... compareFeatures) {
    this.compareFeatures = compareFeatures;
  }

  public static List<PojoCompareResult> compare(Object oldObject, Object newbject) {
    PojoCompareUtil pojoCompareUtil = new PojoCompareUtil();
    return pojoCompareUtil.comparePojo(oldObject, newbject);
  }

  public static List<PojoCompareResult> compare(Object oldObject, Object newbject, CompareFeature... compareFeatures) {
    PojoCompareUtil pojoCompareUtil = new PojoCompareUtil(compareFeatures);
    return pojoCompareUtil.comparePojo(oldObject, newbject);
  }

  private List<PojoCompareResult> comparePojo(Object oldObject, Object newbject) {
    if (oldObject == null
        || newbject == null) {
      throw new ServiceException("both compare object can't be null");
    }
    Class clz = oldObject.getClass();
    Class newClz = oldObject.getClass();
    Class oldClz = clz;
    if (!newClz.getName().equals(oldClz.getName())) {
      throw new ServiceException("class type not equal ");
    }
    List<PojoCompareResult> result = new ArrayList<>();
    //操作
    //字段明
    //新值
    //旧值
    //这个不好用 改用json的方式，方便反序列化
    try {
      List<CompareFeature> compareFeatureList = compareFeatures == null ? new ArrayList<>() : Arrays.asList(compareFeatures);
      for (Field field : clz.getDeclaredFields()) {
        //过滤序列化id
        if (field.getName().equals("serialVersionUID")) {
          continue;
        }
        field.setAccessible(true);
        Object oldValueObj = field.get(oldObject);
        Object newValueObj = field.get(newbject);

        //过滤
        if (compareFeatureList.contains(CompareFeature.StringEmptyAsNull)
            && field.getType() == String.class ) {
          oldValueObj = StringUtils.isBlank(String.valueOf(oldValueObj)) ? null : oldValueObj;
          newValueObj = StringUtils.isBlank(String.valueOf(newValueObj)) ? null : newValueObj;
        }
        //初始化比较结果
        PojoCompareResult compareResult = new PojoCompareResult();
        compareResult.setFieldName(field.getName());
        compareResult.setNewValue(newValueObj);
        compareResult.setOldValue(oldValueObj);


        if (oldValueObj == null && newValueObj != null) {
          compareResult.setOperate(Operate.Insert);
          result.add(compareResult);

        } else if (oldValueObj != null && newValueObj == null) {
          if (compareFeatureList.contains(CompareFeature.EnableNewNullValue)) {
            compareResult.setOperate(Operate.Delete);
            result.add(compareResult);
          }
        } else if (oldValueObj != null) {
          compareResult.setOperate(Operate.Change);
          String oldValueStr = JSONObject.toJSONString(oldValueObj);
          String newValueStr = JSONObject.toJSONString(newValueObj);
          if (!oldValueStr.equals(newValueStr)) {
            result.add(compareResult);
          }
        }
      }
    } catch (IllegalAccessException e) {
      throw new ServiceException(e);
    }
    return result;
  }


  public enum Operate {
    Delete,
    Change,
    Insert
  }

  public enum CompareFeature {
    //空字符串当做null处理
    StringEmptyAsNull,
    //允许重新设值为null，此时等同于如果新值为null，数据库则更新为null值，否则数据库保持原值不变
    EnableNewNullValue

  }


}