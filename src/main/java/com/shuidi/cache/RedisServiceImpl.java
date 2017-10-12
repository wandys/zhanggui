package com.shuidi.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

  private static final Logger log = LoggerFactory.getLogger(RedisService.class);

  @Autowired
  private RedisTemplate redisTemplate;

  private Long defatultExpire = -1L;

  @Override
  public boolean expire(String key, Long expire, TimeUnit timeUnit) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) throws DataAccessException {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        return connection.expire(serializer.serialize(key), timeUnit.toSeconds(expire));
      }
    });
    return (Boolean) result;
  }

  @Override
  public boolean set(String key, String value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          connection.set(serializer.serialize(key), serializer.serialize(value));
          return true;
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public boolean set(String key, String value, Long expire, TimeUnit timeUnit) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          connection.set(serializer.serialize(key), serializer.serialize(value), Expiration.from(expire, timeUnit), RedisStringCommands.SetOption.UPSERT);
          return true;
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public boolean set(String key, Object value) {
    String strValue = JSON.toJSONString(value);
    return set(key, strValue);
  }

  @Override
  public boolean set(String key, Object value, Long expire, TimeUnit timeUnit) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          String strValue = JSON.toJSONString(value);
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          connection.set(serializer.serialize(key), serializer.serialize(strValue), Expiration.from(expire, timeUnit), RedisStringCommands.SetOption.UPSERT);
          return true;
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public long lpush(String key, String value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.lPush(serializer.serialize(key), serializer.serialize(value));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public long lpush(String key, Object value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          String strValue = JSON.toJSONString(value);
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.lPush(serializer.serialize(key), serializer.serialize(strValue));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public long rpush(String key, String value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.rPush(serializer.serialize(key), serializer.serialize(value));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public long rpush(String key, Object value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          String strValue = JSON.toJSONString(value);
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.rPush(serializer.serialize(key), serializer.serialize(strValue));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public Long sAdd(String key, String vaule) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.sAdd(serializer.serialize(key), serializer.serialize(vaule));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public Long sAdd(String key, Object vaule) {
    String strValue = JSONObject.toJSONString(vaule);
    return sAdd(key,strValue);
  }

  @Override
  public Long sRem(String key, String vaule) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.sRem(serializer.serialize(key), serializer.serialize(vaule));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }

  @Override
  public Long sRem(String key, Object vaule) {
    String strValue = JSONObject.toJSONString(vaule);
    return sRem(key,strValue);
  }

  @Override
  public Boolean sIsMember(String key, String vaule) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.sIsMember(serializer.serialize(key), serializer.serialize(vaule));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public Boolean sIsMember(String key, Object vaule) {
    String strValue = JSONObject.toJSONString(vaule);
    return sIsMember(key,strValue);
  }

  @Override
  public List<String> sMembers(String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        List<String> values = new ArrayList<>();
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          Set<byte[]> valueSet = connection.sMembers(serializer.serialize(key));

          valueSet.forEach(bytes -> values.add(serializer.deserialize(bytes)));
          return values;
        } catch (DataAccessException e) {
          log.error("", e);
          return values;
        }

      }
    });
    return (List<String>) result;
  }

  @Override
  public <T> List<T> sMembers(String key,Class<T> clz) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        List<T> values = new ArrayList<>();
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          Set<byte[]> valueSet = connection.sMembers(serializer.serialize(key));

          valueSet.forEach(bytes -> values.add(JSONObject.parseObject(serializer.deserialize(bytes),clz)));
          return values;
        } catch (DataAccessException e) {
          log.error("", e);
          return values;
        }

      }
    });
    return (List<T>) result;
  }

  @Override
  public String lpop(String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return serializer.deserialize(connection.lPop(serializer.serialize(key)));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (String) result;
  }

  @Override
  public <T> T lpop(String key, Class<T> clz) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return serializer.deserialize(connection.lPop(serializer.serialize(key)));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });

    return JSON.parseObject((String) result, clz);
  }

  @Override
  public Boolean setMap(String mapkey, String key, String value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.hSet(serializer.serialize(mapkey), serializer.serialize(key), serializer.serialize(value));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public Boolean setMap(String mapkey, String key, Object value) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          String strValue = JSON.toJSONString(value);
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.hSet(serializer.serialize(mapkey), serializer.serialize(key), serializer.serialize(strValue));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }

  @Override
  public String get(String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return serializer.deserialize(connection.get(serializer.serialize(key)));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (String) result;
  }

  @Override
  public <T> T get(String key, Class<T> clz) {
    String strValue = get(key);
    return JSONObject.parseObject(strValue, clz);
  }

  @Override
  public Map getMap(String mapkey) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          Map<byte[], byte[]> bMap = connection.hGetAll(serializer.serialize(mapkey));
          Map<String, String> stringMap = new HashMap<>();
          bMap.entrySet().forEach(entry -> stringMap.put(serializer.deserialize(entry.getKey()), serializer.deserialize(entry.getValue())));
          return stringMap;
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Map) result;
  }

  @Override
  public <T> Map<String, T> getMap(String mapkey, Class<T> clz) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          Map<byte[], byte[]> bMap = connection.hGetAll(serializer.serialize(mapkey));
          Map<String, String> stringMap = new HashMap<>();
          bMap.entrySet().forEach(entry -> stringMap.put(serializer.deserialize(entry.getKey()), JSONObject.parseObject(entry.getValue(), clz)));
          return stringMap;
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Map) result;
  }

  @Override
  public String getMapValue(String mapkey, String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return serializer.deserialize(connection.hGet(serializer.serialize(mapkey), serializer.serialize(key)));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (String) result;
  }

  @Override
  public <T> T getMapValue(String mapkey, String key, Class<T> clz) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return JSONObject.parseObject(connection.hGet(serializer.serialize(mapkey), serializer.serialize(key)), clz);
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (T) result;
  }

  @Override
  public Long delete(String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          //List<byte[]> bKeys = new ArrayList<>();
          //Arrays.stream(keys).forEach(key -> bKeys.add(serializer.serialize(key)));
          return connection.del(serializer.serialize(key));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }
  @Override
  public Boolean exists(String key) {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.exists(serializer.serialize(key));
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Boolean) result;
  }
  @Override
  public Long dbSize() {
    Object result = redisTemplate.execute(new RedisCallback() {
      @Override
      public Object doInRedis(RedisConnection connection) {
        try {
          RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
          return connection.dbSize();
        } catch (DataAccessException e) {
          log.error("", e);
          return false;
        }

      }
    });
    return (Long) result;
  }
}
