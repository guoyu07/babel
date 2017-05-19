package com.babel.web.book.exception;

import com.babel.web.book.entity.Appointment;

/**
 * Created by allen on 2017/5/19.
 * 预约业务异常
 */
public class AppointException extends RuntimeException{

  public AppointException(String message){
    super(message);
  }

  public AppointException(String message, Throwable cause){
    super(message,cause);
  }

}
