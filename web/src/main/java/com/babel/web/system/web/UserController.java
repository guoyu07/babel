package com.babel.web.system.web;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/5/31.
 */
@RequestMapping("user")
@Controller
public class UserController {

  @RequestMapping(value="/userManage")
  @Description("用户管理")
  public String menuManage(){
    return "system/user";
  }

}
