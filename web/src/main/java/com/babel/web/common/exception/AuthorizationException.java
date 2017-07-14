package com.babel.web.common.exception;

/**
 * Created by allen on 2017/6/9.
 */
public class AuthorizationException extends RuntimeException {

  public AuthorizationException(String message) {
    super(message);
  }

  public AuthorizationException(String message, Throwable cause) {
    super(message, cause);
  }
}
