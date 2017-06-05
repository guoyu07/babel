package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.entity.Menu;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.dto.MenuVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2017/5/22.
 */
@Service
public class MenuServiceImpl implements MenuService{

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final MenuDao menuDao;

  @Autowired
  public MenuServiceImpl(MenuDao menuDao) {
    this.menuDao = menuDao;
  }


  public void addMenu(MenuVo menuVo) {
    Menu menuPo = new Menu();
    menuPo.setGuid(GuidGenerator.newGuid());
    menuPo.setResourceGuid(menuVo.getResourceGuid());
    menuPo.setIconClass(menuVo.getIconClass());
    menuPo.setMenuName(menuVo.getMenuName());
    menuPo.setMenuIndex(menuVo.getMenuIndex());
    menuPo.setParentGuid(menuVo.getParentGuid());
    menuDao.addMenu(menuPo);
  }

  public List<MenuVo> getMenuList() {
    List<MenuVo> menuVos = new ArrayList<MenuVo>();
    List<Menu> menuPos = menuDao.queryAll();
    for (final Menu menuPo : menuPos){
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

  public List<MenuVo> getMainMenus() {
    List<MenuVo> menuVos = new ArrayList<MenuVo>();
    List<Menu> menuPos = menuDao.queryMainMenus();
    for (final Menu menuPo : menuPos){
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
