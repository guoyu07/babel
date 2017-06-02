package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.po.MenuPo;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
@Service
public class MenuServiceImpl implements MenuService{

  private final MenuDao menuDao;

  @Autowired
  public MenuServiceImpl(MenuDao menuDao) {
    this.menuDao = menuDao;
  }


  public void addMenu(MenuVo menuVo) {
    MenuPo menuPo = new MenuPo();
    menuPo.setGuid(GuidGenerator.newGuid());
    menuPo.setResourceGuid("actionGuid");
    menuPo.setIconClass(menuVo.getIconClass());
    menuPo.setMenuName(menuVo.getMenuName());
    menuPo.setMenuIndex(menuVo.getMenuIndex());
    menuPo.setParentGuid("parentGuid");
    menuDao.addMenu(menuPo);
  }

  public List<MenuVo> getAllMenus() {
    List<MenuVo> menuVos = new ArrayList<MenuVo>();
    List<MenuPo> menuPos = menuDao.queryAllMenus();
    for (final MenuPo menuPo : menuPos){
      MenuVo menuVo = new MenuVo();
      menuVo.setGuid(menuPo.getGuid());
      menuVo.setIconClass(menuPo.getIconClass());
      menuVo.setMenuIndex(menuPo.getMenuIndex());
      menuVo.setMenuName(menuPo.getMenuName());
      menuVo.setParentGuid(menuPo.getParentGuid());
      menuVos.add(menuVo);
    }
    return menuVos;
  }
}
