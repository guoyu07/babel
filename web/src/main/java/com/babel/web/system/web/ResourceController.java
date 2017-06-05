package com.babel.web.system.web;

import com.babel.platform.utils.ResponseResult;
import com.babel.platform.utils.RestResultGenerator;
import com.babel.web.system.entity.Resource;
import com.babel.web.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by allen on 2017/5/31.
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

  @Autowired
  ResourceService resourceService;

  @RequestMapping(value = "/getAllResources", method = GET)
  @Description("获取所有资源")
  @ResponseBody
  public ResponseResult getAllResources(){
    List<Resource> resources = resourceService.getAllResources();
    return RestResultGenerator.genResult(resources,null);
  }

}
