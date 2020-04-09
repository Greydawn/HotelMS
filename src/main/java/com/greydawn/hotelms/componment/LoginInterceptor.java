package com.greydawn.hotelms.componment;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("LoginUser");
        //设置session过期时间，单位毫秒，设置-1为永不过期
//        request.getSession().setMaxInactiveInterval(30);
        if(null==user){
            //未登录
            System.out.println("用户未登录！");
            request.setAttribute("msg","用户未登录，请先登录！");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            //已登录
            System.out.println("用户已经登录！"+user);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
