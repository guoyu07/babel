package com.babel.web.system.controller;

import com.babel.platform.utils.JsonUtil;
import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.entity.Role;
import com.babel.web.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  @ResponseBody
  public String roles(){
    Map<String,List<Role>> m = new HashMap<>();
    m.put("data",roleService.getRoles());
    String roles = JsonUtil.objToString(m);
    System.out.println(roles);
    return roles;
  }
}
