package com.babel.web.common.interceptor;

import com.babel.platform.utils.CookieUtil;
import com.babel.platform.utils.JwtUtil;
import com.babel.web.system.entity.User;
import com.babel.web.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/7/11.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);


    @Autowired
    UserService userService;
    /**
     * 在请求之前拦截，返回true则进入请求controller
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getServletPath().toLowerCase().contains("login")){
            return true;
        }
        String jwtToken = CookieUtil.getCookieValue(request,"token");
        if(StringUtils.isEmpty(jwtToken)){
            response.sendRedirect("/login");
            return false;
        }
        User user = JwtUtil.unsign(jwtToken,User.class);
        if(null == user){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，在返回视图前拦截
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在DispatcherServlet完全处理请求后被调用，可用于清理资源等
     * 当有拦截器抛出异常时，会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
