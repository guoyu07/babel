package com.babel.platform.utils;

import java.util.UUID;

/**
 * Created by allen on 2017/5/23.
 */
public class GuidGenenator {
  public static String newGuid(){
    return UUID.randomUUID().toString().replaceAll("-","");
  }
}
