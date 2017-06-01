package com.babel.web.system.service;

import com.babel.web.system.po.ResourcePo;

import java.util.List;

/**
 * Created by allen on 2017/5/27.
 */
public interface ResourceService {

  /**
   * 更新数据库资源
   */
  void updateResources();

  /**
   * 获取所有的资源
   * @return
   */
  List<ResourcePo> getAllResources();

}
