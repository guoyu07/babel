package com.babel.web.book.web;

import com.babel.web.book.dto.User;
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
  @RequestMapping(value = "/home")
  public String home(Model model) {
    model.addAttribute("user",user);
    return "base/_header";
  }
  //入口
  @RequestMapping(value = "/aa")
  public String aa(Model model) {
    model.addAttribute("user",user);
    return "book/aa";
  }
  @RequestMapping(value = "/layout")
  public String layout(Model model) {
    model.addAttribute("user",user);
    return "base/_layout";
  }
  //入口
  @RequestMapping(value = "/bb")
  public String bb(Model model) {
    model.addAttribute("user",user);
    return "book/bb";
  }

//提交表单后进行数据读取，并将数据传出
  @RequestMapping(value = "/bb",method = RequestMethod.POST)
  public String bb(User user, Model model) {
    model.addAttribute("user", user);
    model.addAttribute("message", ",aaaabbbb");
    return "book/bb";
  }
}
