package cn.code.testsys.web.interceptor;

import org.apache.shiro.subject.Subject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import org.apache.shiro.SecurityUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
            Subject subject = SecurityUtils.getSubject();
            if(!subject.isAuthenticated()){
                response.sendRedirect("/login.html");
                return false;
            }
        }
        return true;
    }
}
