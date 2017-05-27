package com.babel.web.book.web;

import com.babel.web.book.vo.User;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by allen on 2017/5/19.
 */
@Controller
public class HomeController {

  User user = new User();

  //入口
  @RequestMapping(value = "/")
  @Description("系统入口")
  public String mainView(Model model) {
    model.addAttribute("user",user);
    return "base/layout";
  }

}
