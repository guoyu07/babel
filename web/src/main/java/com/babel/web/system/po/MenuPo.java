package com.babel.web.system.po;

/**
 * Created by allen on 2017/5/22.
 */
public class MenuPo {
  private String guid;
  private String menuName;
  private String resourceGuid;//关联resourceGuid
  private String resourceName;
  private String parentGuid;
  private int menuIndex;
  private String iconClass;

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

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

}
