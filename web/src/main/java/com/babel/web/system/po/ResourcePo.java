package com.babel.web.system.po;

/**
 * Created by allen on 2017/5/27.
 */
public class ResourcePo {
  private String guid;
  private String resource;
  private String description;
  private int avaliable;

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

  public int getAvaliable() {
    return avaliable;
  }

  public void setAvaliable(int avaliable) {
    this.avaliable = avaliable;
  }
}
