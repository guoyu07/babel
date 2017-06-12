package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.common.cache.RedisClient;
import com.babel.web.common.cache.RedisKeys;
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

  @Autowired
  RedisClient redisClient;


  public void addMenu(Menu menu) {

    redisClient.removeObjectByKey(RedisKeys.MENU.getKey());
    menu.setGuid(GuidGenerator.newGuid());
    menuDao.add(menu);
  }

  public List<Menu> getMenuList() {
    List<Menu> menus = (ArrayList<Menu>)redisClient.getListByKey(RedisKeys.MENU.getKey(),Menu.class);
    if(menus != null){
      return menus;
    }
    menus = menuDao.queryAll();
    redisClient.putListWithExpire(RedisKeys.MENU.getKey(),menus,1000*3000);
    return menus;
  }

  public List<Menu> getMainMenus() {
    List<Menu> menus = menuDao.queryMainMenus();
    return menus;
  }
}
