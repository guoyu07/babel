package com.babel.web.system.service.impl;

import com.babel.platform.utils.GuidGenerator;
import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.system.dao.MenuDao;
import com.babel.web.system.dao.ResourceDao;
import com.babel.web.system.entity.Resource;
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

  private final RequestMappingHandlerMapping handlerMapping;

  private final ResourceDao resourceDao;

  private final MenuDao menuDao;

  @Autowired
  public ResourceServiceImpl(RequestMappingHandlerMapping handlerMapping, ResourceDao resourceDao, MenuDao menuDao) {
    this.handlerMapping = handlerMapping;
    this.resourceDao = resourceDao;
    this.menuDao = menuDao;
  }

  @Transactional
  public void updateResources() {
    List<Resource> resources = getAllResource();
    List<Resource> resourcePosFromDb = resourceDao.queryAllResources();

    //先删除数据库中冗余资源
    for(Resource tmpDbResource : resourcePosFromDb){
      if(null == findResource(resources, tmpDbResource)){
        resourceDao.deleteResource(tmpDbResource);
        menuDao.delete(tmpDbResource.getGuid());
      }
    }

    //再添加新的资源
    for (Resource tmpResource : resources) {
      Resource tmpDbResource = findResource(resourcePosFromDb, tmpResource);
      if (null == tmpDbResource) {
        resourceDao.addResource(tmpResource);
      } else if (!tmpDbResource.getDescription().equals(tmpResource.getDescription())) {
        resourceDao.updateResource(tmpResource);
      }
    }
  }

  public List<Resource> getAllResources() {
    return resourceDao.queryAllResources();
  }

  private Resource findResource(List<Resource> resources, Resource tmpResource) {

    for (Resource resource : resources) {
      if (resource.getResource().equals(tmpResource.getResource())) {
        return resource;
      }
    }
    return null;
  }


  private List<Resource> getAllResource() {
    //获取所有requestMapping
    Map<RequestMappingInfo, HandlerMethod> resourceMap = handlerMapping.getHandlerMethods();
    List<Resource> resourceList = new ArrayList<Resource>();
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
      Description descriptionAnnotation = methodTmp.getAnnotation(Description.class);
      if (null != descriptionAnnotation){
        description = descriptionAnnotation.value();
      }
      ResourceTypeEnum resourceType = ResourceTypeEnum.ACTION;
      ResourceType resourceTypeAnnotation = methodTmp.getAnnotation(ResourceType.class);
      if (null != resourceTypeAnnotation){
        resourceType = resourceTypeAnnotation.value();
      }

      //放入对象
      Resource resource = new Resource();
      resource.setGuid(GuidGenerator.newGuid());
      resource.setResource(url);
      resource.setAvailable(1);
      resource.setResourceType(resourceType.getResourceType());
      resource.setDescription(description);
      resourceList.add(resource);
    }

    return resourceList;

  }
}
