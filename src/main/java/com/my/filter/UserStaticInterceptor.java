package com.my.filter;

import com.my.frame.model.SysUser;
import com.my.frame.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	用户状态拦截
 * @author whm
 * @date 2018/7/27
 */
public class UserStaticInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断session中是否已经有用户
        String userCd = (String)request.getSession().getAttribute("userCd");

        //判断用户状态
        SysUser user = userService.getByUniqueKey("userCd", userCd, SysUser.class);
        //状态正常，正常访问
        if(user.getUserStatus() == 1){
            return true;
        }
        //状态不正常，进入登录页
        else{
            //进入登录页【转发】
            request.getRequestDispatcher("/login/logout").forward(request, response);
            return false;
        }
    }
}
