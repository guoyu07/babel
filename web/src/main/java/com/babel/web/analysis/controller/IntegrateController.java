package com.babel.web.analysis.controller;

import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/6/5.
 */
@Controller
@RequestMapping("/integrate")
public class IntegrateController {
  @RequestMapping(value="/")
  @Description("数据集成页面")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "analysis/integrate";
  }
}
