package com.babel.web.system.dao;

import com.babel.web.system.entity.Resource;

import java.util.List;

/**
 * Created by allen on 2017/5/27.
 */
public interface ResourceDao {

  /**
   * 查找所有资源
   * @return
   */
  List<Resource> queryAllResources();

  /**
   * 新增资源
   * @param resource
   */
  void addResource(Resource resource);

  /**
   * 更新资源
   * @param resource
   */
  void updateResource(Resource resource);

  /**
   * 删除资源
   * @param resource
   */
  void deleteResource(Resource resource);


}
