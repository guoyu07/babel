package com.babel.web.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by allen on 2017/6/12.
 */
@Component
public class RedisExecuteTemplate {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final ShardedJedisPool shardedJedisPool;

  @Autowired
  public RedisExecuteTemplate(ShardedJedisPool shardedJedisPool) {
    this.shardedJedisPool = shardedJedisPool;
  }

  private ShardedJedis getRedisClient(){
    try {
      return shardedJedisPool.getResource();
    }catch (Exception e){
      logger.error("redis服务获取失败:"+e.getMessage());
    }
    return null;
  }

  private void returnResource(ShardedJedis shardedJedis){
    shardedJedisPool.returnResource(shardedJedis);
  }

  Object execute(ExecuteCallback executeCallback){

    ShardedJedis shardedJedis = getRedisClient();
    if(shardedJedis == null){
      return null;
    }

    try {
      return executeCallback.command(shardedJedis);
    }catch (Exception e){
      logger.error("redis执行命令失败:"+e.getMessage());
    }finally {
      returnResource(shardedJedis);
    }
    return null;
  }


  interface ExecuteCallback{
    Object command(ShardedJedis shardedJedis);
  }
}
