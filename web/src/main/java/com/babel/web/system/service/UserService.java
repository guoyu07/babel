package com.babel.web.system.service;

import com.babel.web.system.entity.User;

/**
 * Created by allen on 2017/6/9.
 */
public interface UserService {

  void add(User user);

  void update(User user);

  void delete(User user);

  User query(String userName);

  User login(String userName, String password);
}
