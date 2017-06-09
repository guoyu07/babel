package com.babel.web.common.exception;

/**
 * Created by allen on 2017/6/9.
 */
public class ClientException extends RuntimeException {

  public ClientException(String message) {
    super(message);
  }

  public ClientException(String message, Throwable cause) {
    super(message, cause);
  }
}
