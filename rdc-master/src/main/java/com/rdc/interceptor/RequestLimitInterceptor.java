package com.rdc.interceptor;


import com.rdc.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IpService ipService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        if(ipService.countTimes(ip)){
            return true;
        }else {
            throw new Exception("你提交得太频繁啦，不如坐下来喝一杯茶冷静一下");
        }
    }
}
