package com.shuidi.cache;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.exception.ServiceException;
import com.shuidi.uc.api.encrypt.EncryptMD5;
import org.apache.commons.lang.StringUtils;

public class CacheKeyGeneter {


  public static String getPojoKey(Object key, String field) {
    if (StringUtils.isBlank(field)) {
      field = "id";
    }
    JSONObject keyObject = JSONObject.parseObject(JSONObject.toJSONString(key));
    String value = "";
    if (!keyObject.containsKey(field) || StringUtils.isBlank(value = keyObject.getString(field))) {
      throw new ServiceException("field \"" + field + "\" not exist or value is null");
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(CacheZone.POJO.name()).append(":");
    stringBuilder.append(key.getClass().getName()).append(":");
    stringBuilder.append(value);
    return stringBuilder.toString();

  }

  public static String getKey(CacheZone zone, Class classType, Object key) {
    String paramStr = JSONObject.toJSONString(key);
    String paramSign = EncryptMD5.md5(paramStr);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(zone.name()).append(":");
    stringBuilder.append(classType.getName()).append(":");
    stringBuilder.append(paramSign);
    return stringBuilder.toString();

  }

  public static String getKey(CacheZone zone, Class classType, String method, Object key) {
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
