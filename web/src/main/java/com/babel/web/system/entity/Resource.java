package com.babel.web.system.entity;

/**
 * Created by allen on 2017/5/27.
 */
public class Resource {
  private String guid;
  private String resource;
  private String description;
  private int available;
  private int resourceType;//资源类型 0:menu 1:tab 2:action

  public int getResourceType() {
    return resourceType;
  }

  public void setResourceType(int resourceType) {
    this.resourceType = resourceType;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getAvailable() {
    return available;
  }

  public void setAvailable(int available) {
    this.available = available;
  }
}
