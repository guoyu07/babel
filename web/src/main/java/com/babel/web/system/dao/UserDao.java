package com.babel.web.system.dao;

import com.babel.web.system.entity.User;

/**
 * Created by allen on 2017/5/31.
 */
public interface UserDao {

  /**
   * 新增用户
   * @param user
   * @return
   */
  int add(User user);

  /**
   * 修改用户信息
   * @param user
   * @return
   */
  int update(User user);

  /**
   * 删除用户信息
   * @param guid
   * @return
   */
  int delete(String guid);

  /**
   * 查询用户
   * @param guid
   * @return
   */
  User query(String guid);
}
