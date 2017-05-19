package com.babel.web.book.exception;

/**
 * Created by allen on 2017/5/19.
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

  public RepeatAppointException(String message){
    super(message);
  }

  public RepeatAppointException(String message, Throwable cause){
    super(message,cause);
  }
}
