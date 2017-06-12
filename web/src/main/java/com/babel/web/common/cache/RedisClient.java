package com.babel.web.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;

/**
 * Created by allen on 2017/6/12.
 */
@Component("redisClient")
public class RedisClient {

  @Autowired
  private RedisExecuteTemplate redisExecuteTemplate;

  boolean putObjectWithExpire(String key, Object obj, long expireTime) {
    String result = (String)redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {
      byte[] objSeria = SerializationUtil.serializer(obj);
      @Override
      public Object command(ShardedJedis shardedJedis) {
        return shardedJedis.set(key,new String(objSeria),"nx","ex",expireTime);
      }
    });
    return "OK".equals(result);
  }

  Object getObjectByKey(String key, Class<?> clazz) {
    return redisExecuteTemplate.execute(new RedisExecuteTemplate.ExecuteCallback() {
      @Override
      public Object command(ShardedJedis shardedJedis) {
        String str = shardedJedis.get(key);
        return SerializationUtil.deserializer(str.getBytes(),clazz);
      }
    });
  }
}
