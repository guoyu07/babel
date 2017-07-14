package com.babel.web.system.controller;

import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.entity.Role;
import com.babel.web.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by allen on 2017/5/31.
 */
@RequestMapping("/role")
@Controller
public class RoleController {

  @Autowired
  RoleService roleService;

  @RequestMapping(value="/")
  @Description("角色管理")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "system/role";
  }

  @RequestMapping(value="/list")
  @Description("获取全部角色")
  @ResourceType(ResourceTypeEnum.MENU)
  public List<Role> roles(){
    return roleService.getRoles();
  }


}
