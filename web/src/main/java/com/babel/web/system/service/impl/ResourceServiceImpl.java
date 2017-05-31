package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.system.dao.ResourceDao;
import com.babel.web.system.po.ResourcePo;
import com.babel.web.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by allen on 2017/5/27.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

  @Autowired
  RequestMappingHandlerMapping handlerMapping;

  @Autowired
  ResourceDao resourceDao;

  @Transactional
  public void updateResources() {
    List<ResourcePo> resourcePos = getAllResource();
    List<ResourcePo> resourcePosFromDb = resourceDao.queryAllResources();

    //先删除数据库中冗余资源
    for(ResourcePo tmpDbResourcePo : resourcePosFromDb){
      if(null == findResourcePo(resourcePos,tmpDbResourcePo)){
        resourceDao.deleteResource(tmpDbResourcePo);
      }
    }

    //再添加新的资源
    for (ResourcePo tmpResourcePo : resourcePos) {
      ResourcePo tmpDbResourcePo = findResourcePo(resourcePosFromDb, tmpResourcePo);
      if (null == tmpDbResourcePo) {
        resourceDao.addResource(tmpResourcePo);
      } else if (!tmpDbResourcePo.getDescription().equals(tmpResourcePo.getDescription())) {
        resourceDao.updateResource(tmpResourcePo);
      }
    }
  }

  private ResourcePo findResourcePo(List<ResourcePo> resourcePos, ResourcePo tmpResourcePo) {

    for (ResourcePo resourcePo : resourcePos) {
      if (resourcePo.getResource().equals(tmpResourcePo.getResource())) {
        return resourcePo;
      }
    }
    return null;
  }


  private List<ResourcePo> getAllResource() {
    //获取所有requestMapping
    Map<RequestMappingInfo, HandlerMethod> resourceMap = handlerMapping.getHandlerMethods();
    List<ResourcePo> resourcePoList = new ArrayList<ResourcePo>();
    for (RequestMappingInfo key : resourceMap.keySet()) {
      //url
      String url = key.getPatternsCondition().toString().toLowerCase();//小写
      if (StringUtils.isEmpty(url))
        continue;
      url = url.substring(1, url.length() - 1).toLowerCase();//去掉头尾的[和]符号
      //函数
      HandlerMethod valueTmp = resourceMap.get(key);
      Method methodTmp = valueTmp.getMethod();
      //注解
      String description = "未定义";
      Description annotation = methodTmp.getAnnotation(Description.class);
      if (null != annotation)
        description = annotation.value();
      //放入对象
      ResourcePo resourcePo = new ResourcePo();
      resourcePo.setGuid(GuidGenerator.newGuid());
      resourcePo.setResource(url);
      resourcePo.setAvailable(1);
      resourcePo.setDescription(description);
      resourcePoList.add(resourcePo);
    }

    return resourcePoList;

  }
}
