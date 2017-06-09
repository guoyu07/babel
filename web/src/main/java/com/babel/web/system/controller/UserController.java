package com.babel.web.system.controller;

import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/5/31.
 */
@RequestMapping("/user")
@Controller
public class UserController {

  @RequestMapping(value="/")
  @Description("用户管理")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "system/user";
  }

}
