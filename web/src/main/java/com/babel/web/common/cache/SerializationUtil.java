package com.babel.web.common.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by allen on 2017/6/12.
 */
public class SerializationUtil {
  private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

  private static Objenesis objenesis    = new ObjenesisStd(true);

  private static <T> Schema<T> getSchema(Class<T> clazz) {
    @SuppressWarnings("unchecked")
    Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
    if (schema == null) {
      schema = RuntimeSchema.getSchema(clazz);
      if (schema != null) {
        cachedSchema.put(clazz, schema);
      }
    }
    return schema;
  }

  /**
   * 序列化
   *
   * @param obj
   * @return
   */
  public static <T> byte[] serializer(T obj) {
    @SuppressWarnings("unchecked")
    Class<T> clazz = (Class<T>) obj.getClass();
    LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    try {
      Schema<T> schema = getSchema(clazz);
      return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    } finally {
      buffer.clear();
    }
  }

  /**
   * 反序列化
   *
   * @param data
   * @param clazz
   * @return
   */
  public static <T> T deserializer(byte[] data, Class<T> clazz) {
    try {
      T obj = objenesis.newInstance(clazz);
      Schema<T> schema = getSchema(clazz);
      ProtostuffIOUtil.mergeFrom(data, obj, schema);
      return obj;
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  //序列化列表
  public static <T> byte[] serializeList(List<T> objList) {
    if (objList == null || objList.isEmpty()) {
      throw new RuntimeException("序列化对象列表(" + objList + ")参数异常!");
    }
    @SuppressWarnings("unchecked")
    Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(objList.get(0).getClass());
    LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    byte[] protostuff = null;
    ByteArrayOutputStream bos = null;
    try {
      bos = new ByteArrayOutputStream();
      ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
      protostuff = bos.toByteArray();
    } catch (Exception e) {
      throw new RuntimeException("序列化对象列表(" + objList + ")发生异常!", e);
    } finally {
      buffer.clear();
      try {
        if(bos!=null){
          bos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return protostuff;
  }

  //反序列化列表
  public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
    if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
      throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
    }

    Schema<T> schema = RuntimeSchema.getSchema(targetClass);
    List<T> result;
    try {
      //核心代码
      result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
    } catch (IOException e) {
      throw new RuntimeException("反序列化对象列表发生异常!",e);
    }
    return result;
  }

}
