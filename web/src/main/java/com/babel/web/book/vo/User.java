package com.babel.web.book.vo;

/**
 * Created by allen on 2017/5/19.
 */
public class User {
  private  int id;
  private String name;
  private String msg;
  public User(){}
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMsg() {
    return msg;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}