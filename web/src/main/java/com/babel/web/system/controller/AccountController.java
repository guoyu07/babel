package com.babel.web.system.controller;

import com.babel.platform.utils.GuidGenerator;
import com.babel.platform.utils.JwtUtil;
import com.babel.platform.utils.ResponseData;
import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.entity.Menu;
import com.babel.web.system.entity.User;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allen on 2017/6/8.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  UserService userService;

  @Autowired
  MenuService menuService;

  @RequestMapping(value="/" ,method = GET)
  @Description("登录页")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "account/login";
  }

  @RequestMapping(value="/login" ,method = POST)
  @Description("登录")
  @ResponseBody
  public ResponseData login(String userName, String password){
    User user = userService.login(userName, password);
    ResponseData responseData = ResponseData.ok();
    responseData.putDataValue("user",user);
    String token = JwtUtil.sign(user, 30L * 24L * 3600L * 1000L);
    responseData.putDataValue("token",token);
    return responseData;
  }

  @RequestMapping(value="/register" ,method = POST)
  @Description("注册")
  public String register(String regName,String regEmail, String regPwd){

    User user = new User(GuidGenerator.newGuid(),regName,regPwd,regEmail,1);
    userService.add(user);
    return "/account/main";
  }

  @RequestMapping(value="/main" ,method = GET)
  @Description("首页")
  public String main(){
    return "/account/main";
  }

}
