package com.shuidi.cache;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.uc.api.encrypt.EncryptMD5;

public class CacheKeyGeneter {


  public static String getKey(CacheZone zone, Class classType, Object key) {
    String paramStr = JSONObject.toJSONString(key);
    String paramSign = EncryptMD5.md5(paramStr);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(zone.name()).append(":");
    stringBuilder.append(classType.getName()).append(":");
    stringBuilder.append(paramSign);
    return stringBuilder.toString();

  }
  public static String getKey(CacheZone zone, Class classType,String method, Object key) {
    String paramStr = JSONObject.toJSONString(key);
    String paramSign = EncryptMD5.md5(paramStr);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(zone.name()).append(":");
    stringBuilder.append(classType.getCanonicalName()).append(":");
    stringBuilder.append(method).append(":");
    stringBuilder.append(paramSign);
    return stringBuilder.toString();

  }

  public enum CacheZone {
    POJO,
    TEMP
  }
}
