package com.babel.web.system.dao;

import com.babel.web.system.entity.Menu;

import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
public interface MenuDao {
  /**
   * 新增菜单项
   * @param menuPo
   */
  void addMenu(Menu menuPo);

  /**
   * 删除菜单项
   * @param resourceGuid
   */
  void deleteMenu(String resourceGuid);

  /**
   * 更新菜单项
   * @param menuPo
   */
  void updateMenu(Menu menuPo);

  /**
   * 查询所有菜单项
   * @return
   */
  List<Menu> queryAll();

  /**
   * 查询所有主菜单项
   * @return
   */
  List<Menu> queryMainMenus();
}
