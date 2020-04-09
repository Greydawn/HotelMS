package com.greydawn.hotelms.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mav=new ModelAndView();
        //针对预期的异常进行特定处理
        if(e instanceof NullPointerException){
            mav.addObject("msg","空指针异常!");
        }else {
            mav.addObject("msg", "未知错误，请联系管理员!");
        }
        mav.setViewName("common/error");
        return mav;
    }
}
