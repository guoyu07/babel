package com.babel.web.system.entity;

/**
 * Created by allen on 2017/6/9.
 */
public class User {
  private String guid;
  private String userName;
  private String password;
  private String email;
  private int enabled;

  public User(String guid, String userName, String password, String email, Integer enabled) {
    this.guid = guid;
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.enabled = enabled;
  }
  public User() {}

  public User(String userName, String password, String email, int enabled) {
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.enabled = enabled;
  }

  public User(String userName, String password, String email) {
    this.userName = userName;
    this.password = password;
    this.email = email;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
            "guid='" + guid + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", enabled=" + enabled +
            '}';
  }
}
