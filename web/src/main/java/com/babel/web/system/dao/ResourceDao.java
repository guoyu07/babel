package com.babel.web.system.dao;

import com.babel.web.system.po.ResourcePo;

import java.util.List;

/**
 * Created by allen on 2017/5/27.
 */
public interface ResourceDao {

  /**
   * 查找所有资源
   * @return
   */
  List<ResourcePo> queryAllResources();

  /**
   * 新增资源
   * @param resourcePo
   */
  void addResource(ResourcePo resourcePo);

  /**
   * 更新资源
   * @param resourcePo
   */
  void updateResource(ResourcePo resourcePo);

  /**
   * 删除资源
   * @param resourcePo
   */
  void deleteResource(ResourcePo resourcePo);


}
