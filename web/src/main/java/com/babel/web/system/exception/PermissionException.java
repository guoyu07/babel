package com.babel.web.system.exception;

/**
 * 权限相关异常
 * Created by allen on 2017/6/3.
 */
public class PermissionException extends RuntimeException {

  public PermissionException(String message) {
    super(message);
  }

  public PermissionException(String message, Throwable cause) {
    super(message, cause);
  }
}
