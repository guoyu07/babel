package com.babel.web.system.controller;

import com.babel.web.common.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by allen on 2017/6/8.
 */
@Controller
@RequestMapping("account")
public class LoginController {

  @RequestMapping(value="/" ,method = GET)
  @Description("登录页")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "account/login";
  }

  @RequestMapping(value="/login" ,method = GET)
  @Description("登录")
  public String login(String userName, String password){

    //1.

    return "/account/main";
  }

}
