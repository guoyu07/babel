package com.babel.web.book.exception;

/**
 * Created by allen on 2017/5/19.
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {
  public NoNumberException(String message){
    super(message);
  }

  public NoNumberException(String message, Throwable cause){
    super(message,cause);
  }
}
