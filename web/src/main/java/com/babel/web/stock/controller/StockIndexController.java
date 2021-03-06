package com.babel.web.stock.controller;

import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.common.annotation.ResourceType;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/6/2.
 */
@Controller
public class StockIndexController {

  @RequestMapping(value="/stock")
  @Description("股票指数")
  @ResourceType(ResourceTypeEnum.MENU)
  public String menuManage(){
    return "stock/stockIndex";
  }
}
