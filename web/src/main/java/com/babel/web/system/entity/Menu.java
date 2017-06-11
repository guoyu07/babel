package com.babel.web.system.entity;

import java.io.Serializable;

/**
 * Created by allen on 2017/5/22.
 */
public class Menu implements Serializable {
  private String guid;
  private String menuName;
  private String resourceGuid;//关联resourceGuid
  private String resource;
  private String parentGuid;
  private int menuIndex;
  private String iconClass;
  private int menuType;

  public int getMenuType() {
    return menuType;
  }

  public void setMenuType(int menuType) {
    this.menuType = menuType;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
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

  public String getParentGuid() {
    return parentGuid;
  }

  public void setParentGuid(String parentGuid) {
    this.parentGuid = parentGuid;
  }

  public String getResourceGuid() {
    return resourceGuid;
  }

  public void setResourceGuid(String resourceGuid) {
    this.resourceGuid = resourceGuid;
  }

}
