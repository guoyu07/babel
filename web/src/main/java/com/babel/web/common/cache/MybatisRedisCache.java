package com.babel.web.common.cache;

import com.babel.platform.utils.RedisUtil;
import com.babel.platform.utils.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by allen on 2017/6/10.
 */
public class MybatisRedisCache implements Cache {

  private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
  private  final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private String id;

  public MybatisRedisCache(final String id){
    if(id == null){
      throw new IllegalArgumentException("Cache instances require an Id");
    }
    logger.debug(">>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);
    this.id=id;
  }


  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public void putObject(Object key, Object value) {
    logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
    RedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
  }

  @Override
  public Object getObject(Object key) {
    Object value = SerializeUtil.unserialize(RedisUtil.getJedis().get(SerializeUtil.serialize(key.toString())));
    logger.debug(">>>>>>>>>getObject:"+key+"="+value);
    return value;
  }

  @Override
  public Object removeObject(Object key) {
    return RedisUtil.getJedis().expire(SerializeUtil.serialize(key.toString()),0);
  }

  @Override
  public void clear() {
    RedisUtil.getJedis().flushDB();
  }

  @Override
  public int getSize() {
    return Integer.valueOf(RedisUtil.getJedis().dbSize().toString());
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return null;
  }
}
