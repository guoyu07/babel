package com.babel.web.common.exception;

/**
 * Created by allen on 2017/6/9.
 */
public class AuthenticationException extends RuntimeException {

  public AuthenticationException(String message) {
    super(message);
  }

  public AuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
