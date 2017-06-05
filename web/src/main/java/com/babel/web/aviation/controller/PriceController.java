package com.babel.web.aviation.controller;

import com.babel.web.common.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/6/5.
 */
@Controller
@RequestMapping("/price")
public class PriceController {
  @RequestMapping(value="/")
  @Description("机票数据页面")
  @ResourceType(ResourceTypeEnum.MENU)
  public String home(){
    return "aviation/ticket";
  }

}
