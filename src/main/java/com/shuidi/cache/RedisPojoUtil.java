/*
 * Created by wandy on 2017-09-19.
 */

package com.shuidi.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2017-09-19
 */
public class RedisPojoUtil {

  private SerializerFeature[] serializerFeatures;

  public RedisPojoUtil() {

  }

  public RedisPojoUtil(SerializerFeature... features) {
    serializerFeatures = features;
  }

  public <T> Map toMap(T object, Class<T> clz) {
    Map<String, String> map = new HashMap<>();
    //这个不好用 改用json的方式，方便反序列化
    for (Field field : clz.getDeclaredFields()) {
      field.setAccessible(true);
      try {
        if (field.getType() == String.class) {
          map.put(field.getName(), (String) field.get(object));
        } else if (field.getType() == Integer.class || field.getType() == int.class) {
          map.put(field.getName(), String.valueOf(field.getInt(object)));
        } else if (field.getType() == Long.class || field.getType() == long.class) {
          map.put(field.getName(), String.valueOf(field.getInt(object)));
        } else if (field.getType() == Double.class || field.getType() == double.class) {
          map.put(field.getName(), String.valueOf(field.getDouble(object)));
        } else if (field.getType() == Float.class || field.getType() == float.class) {
          map.put(field.getName(), String.valueOf(field.getDouble(object)));
        } else if (field.getType() == Character.class || field.getType() == char.class) {
          map.put(field.getName(), String.valueOf(field.getChar(object)));
        } else if (field.getType() == Boolean.class || field.getType() == boolean.class) {
          map.put(field.getName(), String.valueOf(field.getBoolean(object)));
        } else if (field.getType() == Byte.class || field.getType() == byte.class) {
          map.put(field.getName(), String.valueOf(field.getByte(object)));
        } else {
          //采用fastJson方式序列化
          map.put(field.getName(), JSONObject.toJSONString(field.get(object)));
        }
      } catch (Exception e) {
        System.out.print(e);
      }
    }
   /* String jsonStr = JSONObject.toJSONString(object);
    JSONObject jsonObject = JSONObject.parseObject(jsonStr);
    jsonObject.entrySet().stream().forEach(stringObjectEntry -> {
      map.put(stringObjectEntry.getKey(), String.valueOf(stringObjectEntry.getValue()));
    });*/

    map = fillter(map);
    return map;
  }

  public <T> T toPojo(Map<String, String> map, Class<T> clz) throws Exception {
    //Object object = c.newInstance();
    Map<String, Object> parseMap = new HashMap<>();
    for (Field field : clz.getDeclaredFields()) {
      field.setAccessible(true);
      try {
        if (!map.containsKey(field.getName())) {
          continue;
        }
        if (field.getType() == String.class) {
          //本来已经是string类型 无需在做转换操作
          parseMap.put(field.getName(), map.get(field.getName()));
        } else if (field.getType() == Integer.class || field.getType() == int.class ) {
          parseMap.put(field.getName(), Integer.parseInt(map.get(field.getName())));
        } else if (field.getType() == Long.class || field.getType() == long.class) {
          parseMap.put(field.getName(), Long.parseLong(map.get(field.getName())));
        } else if (field.getType() == Double.class || field.getType() == double.class) {
          parseMap.put(field.getName(), Double.parseDouble(map.get(field.getName())));
        } else if (field.getType() == Float.class || field.getType() == float.class) {
          parseMap.put(field.getName(), Float.parseFloat(map.get(field.getName())));
        } else if (field.getType() == Character.class || field.getType() == char.class) {
          parseMap.put(field.getName(), map.get(field.getName()).charAt(0));
        } else if (field.getType() == Boolean.class || field.getType() == boolean.class) {
          parseMap.put(field.getName(), Boolean.parseBoolean(map.get(field.getName())));
        } else if (field.getType() == Byte.class || field.getType() == byte.class) {
          parseMap.put(field.getName(), Byte.parseByte(map.get(field.getName())));
        } else {
          //采用fastJson方式序列化
          parseMap.put(field.getName(), JSONObject.parse(map.get(field.getName())));
        }
      } catch (Exception e) {
        System.out.print(e);
      }
    }
    String jsonStr = JSONObject.toJSONString(parseMap);
    return (T) JSON.parseObject(jsonStr,clz);
  }


  /**
   * 过滤结果.
   *
   * @param map
   */
  private Map<String, String> fillter(Map<String, String> map) {
    if (serializerFeatures == null || !Arrays.asList(serializerFeatures).contains(SerializerFeature.WriteMapNullValue)) {
      map = nullFilter(map);
    }
    /*Arrays.stream(serializerFeatures).forEach(serializerFeature -> {
      if (serializerFeature == SerializerFeature.WriteMapNullValue) {

      }

    });*/
    return map;
  }

  /**
   * 过滤空值.
   *
   * @param map 待过滤内容
   */
  private Map<String, String> nullFilter(Map<String, String> map) {
    Map<String, String> nMap = new HashMap<>();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (!"null".equals(entry.getValue()) && StringUtils.isNotBlank(entry.getValue())) {
        nMap.put(entry.getKey(), entry.getValue());
      }
    }
    return nMap;
  }

  /**
   * @author wenshao[szujobs@hotmail.com]
   */
 /* public enum SerializerFeature {
    WriteMapNullValue,;
  }*/
}