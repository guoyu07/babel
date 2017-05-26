package com.babel.web.system.service;

import com.babel.web.system.vo.MenuVo;

/**
 * Created by allen on 2017/5/22.
 */
public interface MenuService {

  /**
   * 添加菜单项
   * @param menuVo
   */
  void addMenu(MenuVo menuVo);
}
