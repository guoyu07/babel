package com.babel.platform.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by allen on 2017/6/11.
 */
public class SerializeUtil {

  private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);

  /**
   * 序列化
   * @param object
   */
  public static byte[] serialize(Object object) {
    ObjectOutputStream oos;
    ByteArrayOutputStream baos;
    try {
      // 序列化
      baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      oos.writeObject(object);
      byte[] bytes = baos.toByteArray();
      return bytes;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 反序列化
   * @param bytes
   */
  public static Object unserialize(byte[] bytes) {
    ByteArrayInputStream bais;
    try {
      // 反序列化
      bais = new ByteArrayInputStream(bytes);
      ObjectInputStream ois = new ObjectInputStream(bais);
      return ois.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
