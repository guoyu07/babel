package com.babel.web.system.service.impl;

import com.babel.web.common.exception.ServerException;
import com.babel.web.system.dao.UserDao;
import com.babel.web.system.entity.User;
import com.babel.web.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allen on 2017/6/9.
 */
@Service
public class UserServiceImpl implements UserService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  UserDao userDao;

  public void add(User user) {
    int count = userDao.add(user);
    if(count>0){
      logger.info("添加用户成功:" +user.getUserName());
    }else {
      logger.error("添加用户失败");
      throw new ServerException("添加用户失败");
    }
  }

  public void update(User user) {

  }

  public void delete(User user) {

  }

  public void query(String userName) {

  }
}
