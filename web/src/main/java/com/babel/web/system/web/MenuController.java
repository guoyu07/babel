package com.babel.web.system.web;

import com.babel.platform.utils.ResponseResult;
import com.babel.platform.utils.RestResultGenerator;
import com.babel.web.common.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.dto.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
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

  private static MenuService staticMenuService;

  @Autowired
  public MenuController(MenuService menuService) {
    this.menuService = menuService;
  }

  @PostConstruct
  private void initMenuService(){
    staticMenuService = this.menuService;
  }

  @RequestMapping(value="/")
  @Description("菜单管理")
  @ResourceType(ResourceTypeEnum.MENU)
  public String menuManage(){
    return "system/menu";
  }

  @RequestMapping(value="/add", method = POST)
  @Description("添加菜单")
  public String addMenu(MenuVo menuVo){
    menuService.addMenu(menuVo);
    return "system/menu";
  }

  @Description("获取所有菜单项")
  @ResponseBody
  @RequestMapping(value = "/list",method = GET)
  public List<MenuVo> list(){
    return menuService.getMenuList();
  }

  public static List<MenuVo> getMenus(){
    return staticMenuService.getMenuList();
  }

  @RequestMapping(value = "/mainMenus", method = GET)
  @Description("获取所有主菜单项")
  @ResponseBody
  public ResponseResult<List<MenuVo>> getMainMenus(){
    List<MenuVo> menuVos = menuService.getMainMenus();
    return RestResultGenerator.genResult(menuVos,null);
  }
}
