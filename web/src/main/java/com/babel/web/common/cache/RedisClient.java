package com.babel.web.common.cache;

import javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2017/6/12.
 */
@Component("redisClient")
public class RedisClient {

  @Autowired
  private RedisExecuteTemplate redisExecuteTemplate;

  public boolean putObjectWithExpire(String key, Object obj, long expireTime) {
    String result = (String)redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {

      byte[] objSeria = obj instanceof List ? SerializationUtil.serializeList((ArrayList)obj) : SerializationUtil.serializer(obj);
      @Override
      public Object command(ShardedJedis shardedJedis) {
        return shardedJedis.set(key,new String(objSeria),"nx","ex",expireTime);
      }
    });
    return "OK".equals(result);
  }

  public boolean putListWithExpire(String key, List list, long expireTime) {
    String result = (String)redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {

      byte[] objSeria = SerializationUtil.serializeList(list);
      @Override
      public Object command(ShardedJedis shardedJedis) {
        return shardedJedis.set(key,new String(objSeria),"nx","ex",expireTime);
      }
    });
    return "OK".equals(result);
  }

  public Object getObjectByKey(String key, Class<?> clazz) {
    return redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {
      @Override
      public Object command(ShardedJedis shardedJedis) {
        String str = shardedJedis.get(key);
        return SerializationUtil.deserializer(str.getBytes(),clazz);
      }
    });
  }

  public Object getListByKey(String key, Class<?> clazz) {
    return redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {
      @Override
      public Object command(ShardedJedis shardedJedis) {
        String str = shardedJedis.get(key);
        return SerializationUtil.deserializeList(str.getBytes(),clazz);
      }
    });
  }

  public void removeObjectByKey(String key){
    redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {
      @Override
      public Object command(ShardedJedis shardedJedis) {
        return shardedJedis.del(key);
      }
    });
  }

}
