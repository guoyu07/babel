package com.babel.web.system.vo;

/**
 * Created by allen on 2017/5/22.
 */
public class MenuVo {

  private String parentName;
  private String menuName;
  private String menuIndex;
  private String iconClass;

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuIndex() {
    return menuIndex;
  }

  public void setMenuIndex(String menuIndex) {
    this.menuIndex = menuIndex;
  }

  public String getIconClass() {
    return iconClass;
  }

  public void setIconClass(String iconClass) {
    this.iconClass = iconClass;
  }
}
