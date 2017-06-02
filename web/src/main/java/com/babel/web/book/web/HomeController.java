package com.babel.web.book.web;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allen on 2017/5/19.
 */
@Controller
public class HomeController {


  //入口
  @RequestMapping(value = "/")
  @Description("系统入口")
  public String mainView(Model model) {
    return "base/layout";
  }

}
