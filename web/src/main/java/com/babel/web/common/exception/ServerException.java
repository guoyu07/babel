package com.babel.web.common.exception;

/**
 * Created by allen on 2017/6/9.
 */
public class ServerException extends RuntimeException {

  public ServerException(String message) {
    super(message);
  }

  public ServerException(String message, Throwable cause) {
    super(message, cause);
  }
}
