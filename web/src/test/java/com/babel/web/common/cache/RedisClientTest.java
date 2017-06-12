package com.babel.web.common.cache;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.system.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by allen on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:/spring/spring-redis.xml"})
public class RedisClientTest {

  @Autowired
  private RedisClient redisClient;

  @Test
  public void putObjectWithExpire() throws Exception {
    Menu menu = new Menu();
    menu.setGuid(GuidGenerator.newGuid());
    menu.setIconClass("menu");
    menu.setMenuIndex(1);
    menu.setMenuName("测试菜单1");
    menu.setMenuType(0);
    menu.setResource("aaa/aaa");
    redisClient.putObjectWithExpire("menu", menu, 100);
  }

  @Test
  public void getObjectByKey() throws Exception {
    Menu menu = (Menu) redisClient.getObjectByKey("menu", Menu.class);
    System.out.println(menu.getMenuName());
  }

}