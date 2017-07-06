package com.babel.web.system.service;

import com.babel.web.system.entity.Menu;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
public interface MenuService {

  /**
   * 添加菜单项
   * @param menuVo
   */
  void addMenu(Menu menuVo);

  /**
   * 查询所有菜单项
   */
  List<Menu> getMenuList();

  /**
   * 查询所有主菜单项
   */
  List<Menu> getMainMenus();

  /**
   * 查询用户的菜单项
   */
  List<Menu> getUserMenus(String userName);

}
