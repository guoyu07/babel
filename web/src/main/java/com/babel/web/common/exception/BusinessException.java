package com.babel.web.common.exception;

/**
 * Created by allen on 2017/6/9.
 */
public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message,cause);
  }

}
