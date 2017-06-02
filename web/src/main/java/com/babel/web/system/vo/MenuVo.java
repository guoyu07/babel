package com.babel.web.system.vo;

/**
 * Created by allen on 2017/5/22.
 */
public class MenuVo {

  private String guid;
  private String menuName;
  private String parentGuid;
  private String parentName;
  private String resourceGuid;
  private String resource;
  private int menuIndex;
  private String iconClass;
  private int menuType; //0:主菜单 1:子菜单

  public int getMenuType() {
    return menuType;
  }

  public void setMenuType(int menuType) {
    this.menuType = menuType;
  }

  public String getResourceGuid() {
    return resourceGuid;
  }

  public void setResourceGuid(String resourceGuid) {
    this.resourceGuid = resourceGuid;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

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

  public String getParentGuid() {
    return parentGuid;
  }

  public void setParentGuid(String parentGuid) {
    this.parentGuid = parentGuid;
  }
}
