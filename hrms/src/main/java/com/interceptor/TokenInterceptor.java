package com.interceptor;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pojo.Response;
import com.util.RequirePermission;
import com.util.TokenUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;


public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token != null) {
            DecodedJWT jwt = TokenUtils.verify(token);
            if (jwt != null) {
                String username = jwt.getClaim("username").asString();
                if (username.length() > 0) {
                    if (!(handler instanceof HandlerMethod)) {
                        return true;
                    }
                    List<String> permissions = jwt.getClaim("permissions").asList(String.class);
                    if (permissions != null) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        Method method = handlerMethod.getMethod();
                        RequirePermission annotation = method.getAnnotation(RequirePermission.class);
                        String[] value = annotation.value();
                        String name = value[0];
                        String expression = value[1];
                        if ("user:editPassword".equals(expression)) {
                            return true;
                        }
                        if (permissions.contains(expression)) {
                            return true;
                        }
                    }
                    Response<Object> resp = new Response<>(3, "对不起，您没有执行该操作的权限！", null);
                    String s = JSON.toJSONString(resp);
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    response.getWriter().write(s);
                    return false;
                }
            }
            return false;
        } else {
            response.sendRedirect("http://localhost/");
            return false;
        }

    }
}
