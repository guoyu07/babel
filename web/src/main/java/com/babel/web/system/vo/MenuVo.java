package com.babel.web.system.vo;

/**
 * Created by allen on 2017/5/22.
 */
public class MenuVo {

  private String guid;
  private String parentName;
  private String menuName;
  private int menuIndex;
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

  public int getMenuIndex() {
    return menuIndex;
  }

  public void setMenuIndex(int menuIndex) {
    this.menuIndex = menuIndex;
  }

  public String getIconClass() {
    return iconClass;
  }

  public void setIconClass(String iconClass) {
    this.iconClass = iconClass;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }
}
