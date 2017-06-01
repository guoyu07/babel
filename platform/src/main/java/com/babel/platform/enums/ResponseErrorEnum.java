package com.babel.platform.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by allen on 2017/6/1.
 */
public enum ResponseErrorEnum {

  ILLEGAL_PARAMS("ILLEGAL_PARAMS","请求参数不合法!"),
  INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR","接口内部异常");


  private String code;
  private String message;


  ResponseErrorEnum(String code, String message){
    this.code = code;
    this.message = message;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @JsonValue
  private Map<String,Object> serialize(){
    Map<String, Object> valueMap = new HashMap<>(2);
    valueMap.put("code", this.code);
    valueMap.put("message", this.message);
    return valueMap;
  }


}
