package com.example.cake.inter;

import com.example.cake.model.LoginInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginChecker implements HandlerInterceptor {

    @Resource
    LoginInfo loginInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        boolean isLogin = true;
        System.out.println(loginInfo.getU_id());
        if(loginInfo.getU_id() == null){ // 멈춰
            System.out.println("로그인 해!");
            isLogin = false;
        }
        request.setAttribute("isLogin",isLogin);
    }
}
