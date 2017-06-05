package com.babel.web.system.controller;

import com.babel.web.common.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/5/31.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

  @RequestMapping(value="/")
  @Description("权限管理")
  @ResourceType(ResourceTypeEnum.MENU)
  public String menuManage(){
    return "system/permission";
  }


}
