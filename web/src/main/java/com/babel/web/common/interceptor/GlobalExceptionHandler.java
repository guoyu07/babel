package com.babel.web.common.interceptor;

import com.babel.platform.utils.JsonUtil;
import com.babel.platform.utils.ResponseResult;
import com.babel.platform.utils.RestResultGenerator;
import com.babel.web.common.exception.BusinessException;
import com.babel.web.common.exception.ClientException;
import com.babel.web.common.exception.ServerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by allen on 2017/6/9.
 */
@ControllerAdvice
public class GlobalExceptionHandler{

  @ExceptionHandler(ClientException.class)
  public void handleClientException(HttpServletRequest request, HttpServletResponse response, ClientException e){

  }

  @ExceptionHandler(BusinessException.class)
  public void handleBusinessException(HttpServletRequest request, HttpServletResponse response, BusinessException e){

  }

  @ExceptionHandler(ServerException.class)
  public void handleServerException(HttpServletRequest request, HttpServletResponse response, ServerException e){

  }

  private void outputMessage(HttpServletResponse response, String errMsg) throws IOException {
    ResponseResult result = RestResultGenerator.genErrorResult(errMsg);
    String json = JsonUtil.objToString(result);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/json");
    ServletOutputStream os = response.getOutputStream();
    os.write(json.getBytes("utf-8"));
  }


}
