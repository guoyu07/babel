package com.babel.web.common.cache;

/**
 * Created by allen on 2017/6/12.
 */
public enum RedisKeys {
  MENU("menu");

  private String key;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  RedisKeys(String key){
    this.key = key;
  }
}
