package com.babel.web.system.web;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/5/31.
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

  @RequestMapping(value="/permissionManage")
  @Description("权限管理")
  public String menuManage(){
    return "system/permission";
  }


}
