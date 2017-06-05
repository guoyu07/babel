package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.entity.Menu;
import com.babel.web.system.service.MenuService;
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


  public void addMenu(Menu menu) {
    menu.setGuid(GuidGenerator.newGuid());
    menuDao.addMenu(menu);
  }

  public List<Menu> getMenuList() {
    return menuDao.queryAll();

  }

  public List<Menu> getMainMenus() {
    List<Menu> menus = menuDao.queryMainMenus();
    return menus;
  }
}
