package com.babel.web.system.service;

import com.babel.web.system.dto.MenuVo;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
public interface MenuService {

  /**
   * 添加菜单项
   * @param menuVo
   */
  void addMenu(MenuVo menuVo);

  /**
   * 查询所有菜单项
   */
  List<MenuVo> getMenuList();

  /**
   * 查询所有主菜单项
   */
  List<MenuVo> getMainMenus();

}
