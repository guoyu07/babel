package com.babel.web.system.dao;

import com.babel.web.system.po.MenuPo;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
public interface MenuDao {
  /**
   * 新增菜单项
   * @param menuPo
   */
  void addMenu(MenuPo menuPo);

  /**
   * 删除菜单项
   * @param guid
   */
  void deleteMenu(String guid);

  /**
   * 更新菜单项
   * @param menuPo
   */
  void updateMenu(MenuPo menuPo);

  /**
   * 查询所有菜单项
   * @return
   */
  List<MenuPo> queryAllMenus();

  /**
   * 查询所有主菜单项
   * @return
   */
  List<MenuPo> queryMainMenus();
}
