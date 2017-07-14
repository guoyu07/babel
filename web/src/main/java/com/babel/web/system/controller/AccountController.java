package com.babel.web.system.controller;

import com.babel.platform.utils.GuidGenerator;
import com.babel.platform.utils.JwtUtil;
import com.babel.web.common.annotation.ResourceType;
import com.babel.web.common.enums.ResourceTypeEnum;
import com.babel.web.system.entity.User;
import com.babel.web.system.service.MenuService;
import com.babel.web.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allen on 2017/6/8.
 */
@Controller
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/login", method = GET)
    @Description("登录页")
    @ResourceType(ResourceTypeEnum.MENU)
    public String home() {
        return "/account/login";
    }

    @RequestMapping(value = "/logout", method = GET)
    @Description("注销")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        for (Cookie tmpCookie:request.getCookies()) {
            tmpCookie.setMaxAge(0);
            tmpCookie.setValue(null);
            tmpCookie.setPath("/");
            response.addCookie(tmpCookie);
        }
        return "account/login";
    }

    @RequestMapping(value = "/doLogin", method = POST)
    @Description("登录")
    public String login(String userName, String password, HttpServletResponse response) {
        User user = userService.login(userName, password);
        String token = JwtUtil.sign(user, 30L * 24L * 3600L * 1000L);
        Cookie userNameCookie = new Cookie("userName", user.getUserName());
        userNameCookie.setMaxAge(20*60);
        userNameCookie.setHttpOnly(true);
        userNameCookie.setPath("/");
        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(20*60);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
        response.addCookie(userNameCookie);
        return "/account/main";
    }

    @RequestMapping(value = "/doRegister", method = POST)
    @Description("注册")
    public String register(String regName, String regEmail, String regPwd) {
        User user = new User(GuidGenerator.newGuid(), regName, regPwd, regEmail, 1);
        userService.add(user);
        return "/account/main";
    }

    @RequestMapping(value = "/", method = GET)
    @Description("首页")
    public String main() {
        return "/account/main";
    }
}
