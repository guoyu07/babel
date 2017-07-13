package com.babel.web.common.interceptor;

import com.babel.platform.utils.CookieUtil;
import com.babel.platform.utils.JwtUtil;
import com.babel.web.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lenovo on 2017/7/11.
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    /**
     * 在请求之前拦截，返回true则进入请求controller
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        String url = request.getContextPath();
        logger.debug("RequestUri:"+requestUri);
        logger.debug("method:"+method);
        logger.debug("url:"+url);
        if(request.getServletPath().toLowerCase().contains("login")){
            return true;
        }
        String jwtToken = CookieUtil.getCookieValue(request,"token");
        if(StringUtils.isEmpty(jwtToken)){
            response.sendRedirect("/login");
            return false;
        }
        User user = (User)JwtUtil.unsign(jwtToken,User.class);
        if(null == user){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，在返回视图前拦截
     * 可在modelAndView中加入数据，比如当前时间
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("==============执行顺序: 2、postHandle================");
        if (null!=modelAndView){
//            modelAndView.addObject("serverTime", DateUtils.getDate(DateUtils.YYYY_MM_DD_HH_mm_ss));
        }
    }

    /**
     * 在DispatcherServlet完全处理请求后被调用，可用于清理资源等
     * 当有拦截器抛出异常时，会从当前拦截器往回执行所有的拦截器的afterCompletion()
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("==============执行顺序: 3、afterCompletion================");
    }
}
