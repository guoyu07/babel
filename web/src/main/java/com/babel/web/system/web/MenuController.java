package com.babel.web.system.web;

import com.babel.web.system.service.MenuService;
import com.babel.web.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allen on 2017/5/22.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  MenuService menuService;

  @RequestMapping(value="/menuManage")
  @Description("菜单管理")
  public String menuManage(Model model){
    return "system/menuManage";
  }

  @RequestMapping(value="/addMenu", method = POST)
  @Description("添加菜单")
  public String addMenu(MenuVo menuVo){
    menuService.addMenu(menuVo);
    return "system/menuManage";
  }
}
