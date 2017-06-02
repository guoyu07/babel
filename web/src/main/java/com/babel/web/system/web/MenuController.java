package com.babel.web.system.web;

import com.babel.platform.utils.ResponseResult;
import com.babel.platform.utils.RestResultGenerator;
import com.babel.web.common.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allen on 2017/5/22.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

  private final MenuService menuService;

  @Autowired
  public MenuController(MenuService menuService) {
    this.menuService = menuService;
  }

  @RequestMapping(value="/menuManage")
  @Description("菜单管理")
  @ResourceType(ResourceTypeEnum.MENU)
  public String menuManage(){
    return "system/menu";
  }

  @RequestMapping(value="/addMenu", method = POST)
  @Description("添加菜单")
  public String addMenu(MenuVo menuVo){
    menuService.addMenu(menuVo);
    return "system/menu";
  }

  @RequestMapping(value = "/getAllMenus", method = GET)
  @Description("获取所有菜单项")
  @ResponseBody
  public List<MenuVo> getAllMenus(){
    return menuService.getAllMenus();
  }

  @RequestMapping(value = "/getMainMenus", method = GET)
  @Description("获取所有主菜单项")
  @ResponseBody
  public ResponseResult<List<MenuVo>> getMainMenus(){
    List<MenuVo> menuVos = menuService.getMainMenus();
    return RestResultGenerator.genResult(menuVos,null);
  }
}
