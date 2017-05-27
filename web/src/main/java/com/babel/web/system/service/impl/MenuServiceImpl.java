package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenenator;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.po.MenuPo;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allen on 2017/5/22.
 */
@Service
public class MenuServiceImpl implements MenuService{

  @Autowired
  MenuDao menuDao;


  public void addMenu(MenuVo menuVo) {

    MenuPo menuPo = new MenuPo();
    menuPo.setGuid(GuidGenenator.newGuid());
    menuPo.setActionGuid("actionGuid");
    menuPo.setIconClass(menuVo.getIconClass());
    menuPo.setMenuName(menuVo.getMenuName());
    menuPo.setMenuIndex(menuVo.getMenuIndex());
    menuPo.setParentGuid("parentGuid");

    menuDao.addMenu(menuPo);

  }
}
