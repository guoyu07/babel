package com.babel.web.common.init;

import com.babel.web.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by allen on 2017/5/27.
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  ResourceService resourceService;

  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    resourceService.updateResources();
  }
}
