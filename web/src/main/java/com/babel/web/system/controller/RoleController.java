package com.babel.web.system.controller;

import com.babel.platform.utils.JsonUtil;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.common.datatable.DataTableRequest;
import com.babel.web.common.datatable.DataTablesView;
import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.system.entity.Role;
import com.babel.web.system.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by allen on 2017/5/31.
 */
@RequestMapping("/role")
@Controller
public class RoleController {

  private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

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
  public String roles(@Param("aoData") String aoData) throws Exception {
    DataTableRequest dtRequest = new DataTableRequest(aoData);
    PageHelper.startPage(dtRequest.getPageNumber(),dtRequest.getDisplayLength());
    List<Role> roles = roleService.getRoles();
    PageInfo<Role> pageRoles = new PageInfo<>(roles,dtRequest.getPageNumber());
    DataTablesView <Role> rolesDataTable = new DataTablesView<>();
    rolesDataTable.setData(roles);
    rolesDataTable.setRecordsTotal((int) pageRoles.getTotal());
    return JsonUtil.objToString(rolesDataTable);
  }
}
