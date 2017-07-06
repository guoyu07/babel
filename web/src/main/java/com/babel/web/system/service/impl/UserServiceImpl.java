package com.babel.web.system.service.impl;

import com.babel.web.common.exception.ServerException;
import com.babel.web.system.dao.UserDao;
import com.babel.web.system.entity.User;
import com.babel.web.system.exception.PermissionException;
import com.babel.web.system.exception.UserNotFoundException;
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

  public User query(String userName) {
    User user = userDao.query(userName);
    return userDao.query(userName);
  }

  public void login(String userName, String password){
      User user = userDao.query(userName);
      if(null == user){
          throw new UserNotFoundException("对不起，用户" + userName + "未注册");
      }

      if(user.getUserName().equalsIgnoreCase(userName)
              && user.getPassword().equalsIgnoreCase(password)){
      }else{
          throw new PermissionException("对不起，密码不正确！");
      }
  }
}
