package com.babel.platform.utils;

import com.babel.platform.enums.ResponseErrorEnum;

/**
 * Created by allen on 2017/6/1.
 */

/**
 * 所有ajax请求返回结果
 * @param <T>
 */
public class ResponseResult<T> {

  private boolean success;
  private String message;
  private T data;
  private String errorCode;

  private ResponseResult(){}

  static <T> ResponseResult<T> newInstance(){
    return new ResponseResult<T>();
  }


  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
    this.errorCode = responseErrorEnum.getCode();
    this.message = responseErrorEnum.getMessage();
  }
}
