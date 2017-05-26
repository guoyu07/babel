package com.babel.web.system.web;

import com.babel.web.system.service.MenuService;
import com.babel.web.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allen on 2017/5/22.
 */
@Controller
public class MenuController {

  @Autowired
  MenuService menuService;


  @RequestMapping(value="/menuManage")
  public String menuManage(Model model){
    return "system/menuManage";
  }

  @RequestMapping(value="/addMenu", method = POST)
  public String addMenu(MenuVo menuVo){
    System.out.println(menuVo.getIconClass());
    System.out.println(menuVo.getParentName());
    System.out.println(menuVo.getMenuName());
    System.out.println(menuVo.getMenuIndex());

    menuService.addMenu(menuVo);
    return "system/menuManage";
  }
}
