package com.shuidi.cache;

import org.omg.CORBA.TIMEOUT;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisService {

  /**
   * 设置过期时间.
   *
   * @param key key
   * @param expire 过期时长
   * @param timeUnit 时间单位
   * @return
   */
  public boolean expire(String key, Long expire, TimeUnit timeUnit);

  public boolean set(String key, String value);

  public boolean set(String key, String value, Long expire, TimeUnit timeUnit);

  public boolean set(String key, Object value);

  public boolean set(String key, Object value, Long expire, TimeUnit timeUnit);

  public long lpush(String key, String value);

  public long lpush(String key, Object value);

  public long rpush(String key, String value);

  public long rpush(String key, Object value);

  public Long sAdd(String key,String vaule);

  public Long sAdd(String key,Object vaule);

  public Long sRem(String key,String vaule);

  public Long sRem(String key,Object vaule);

  public Boolean sIsMember(String key,String vaule);

  public Boolean sIsMember(String key,Object vaule);

  public List<String> sMembers(String key);

  public <T> List<T> sMembers(String key,Class<T> clz);

  public String lpop(String key);

  public <T> T lpop(String key,Class<T> clz);

  public Boolean setMap(String mapkey, String key, String value);

  public Boolean setMap(String mapkey, String key, Object value);

  public String get(String key);

  public <T> T get(String key,Class<T> clz);

  public Map getMap(String mapkey);

  public <T> Map<String,T> getMap(String mapkey,Class<T> clz);

  public String getMapValue(String mapkey, String key);

  public <T> T getMapValue(String mapkey, String key,Class<T> clz);

  public Long delete(String key);

  public Boolean exists(String key);

  public Long dbSize();

}
