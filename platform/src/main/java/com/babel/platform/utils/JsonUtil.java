package com.babel.platform.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.rmi.ServerException;

/**
 * Created by allen on 2017/5/23.
 */
public class JsonUtil {

  private static ObjectMapper objectMapper = initObjectMapper();
  private static ObjectMapper initObjectMapper(){

    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//
//    objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);
//    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//
//    objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    return objectMapper;
  }

  /**
   * 将java对象转换成json字符串
   */
  public static String objToString(Object obj){
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
