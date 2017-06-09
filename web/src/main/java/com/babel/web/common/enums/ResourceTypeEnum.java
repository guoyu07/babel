package com.babel.web.common.enums;

/**
 * Created by allen on 2017/6/2.
 */
public enum  ResourceTypeEnum {
  MENU(0),
  TAB(1),
  ACTION(2);

  private int resourceType;

  public int getResourceType() {
    return resourceType;
  }

  public void setResourceType(int resourceType) {
    this.resourceType = resourceType;
  }

  ResourceTypeEnum(int resourceType){
    this.resourceType = resourceType;
  }
}
