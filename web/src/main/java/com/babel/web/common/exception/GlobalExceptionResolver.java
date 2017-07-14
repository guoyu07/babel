package com.babel.web.common.exception;

import com.babel.platform.utils.JsonUtil;
import com.babel.platform.utils.ResponseResult;
import com.babel.platform.utils.RestResultGenerator;
import com.babel.web.common.exception.BusinessException;
import com.babel.web.common.exception.ClientException;
import com.babel.web.common.exception.ServerException;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by allen on 2017/6/9.
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    ModelAndView mav = new ModelAndView();
    if (e instanceof AuthenticationException) {
      mav.setViewName("/error/403");
    } else if (e instanceof AuthorizationException) {
      mav.setViewName("/error/404");
    } else {
      mav.setViewName("/error/500");
    }
    mav.addObject("errMessage", e.getMessage());
    return mav;
  }
}
