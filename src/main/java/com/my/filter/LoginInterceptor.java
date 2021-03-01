package com.my.filter;

import com.my.utils.StringUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	登录拦截器
 * @author whm
 * @date 2018/7/27
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //controller访问的相对路径
        String path=request.getServletPath().toLowerCase();
        String contextPath = request.getContextPath();

        //站点前缀字符串——地址
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        String org_prefix_path = "/" + prefix_orgCd;

        //要跳转到登录页
        if("/".equals(path)){
            //进入登录页【转发】
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        //要跳转到错误页面
        else if(path.contains("error")){
            return true;
        }
        //loginController里的链接
        else if(path.contains("login")){
            String[] pathAry = path.split("/");

            //如果数组长度是2，要进入的是登录页，验证是否已经登录，如果已经登录，直接进主页面
            if(pathAry.length == 2){
                //判断session中是否已经有用户
                String userCd = (String)request.getSession().getAttribute("userCd");

                //如果session有，直接进入主页面
                if(null != userCd){
                    //返回框架页【重定向】
                    response.sendRedirect(contextPath + org_prefix_path + "/frame");
                    return false;
                }
            }
            return true;
        }
        //其他链接
        else{
            //判断session中是否已经有用户
            String userCd = (String)request.getSession().getAttribute("userCd");

            /**
             * TODO 如果连接地址没有在menu中控制，不需要权限拦截
             */

            //如果没有用户信息，转发到登录页
            if (null == userCd) {
                if (isAjaxRequest(request)) {
                    //如果是ajax访问并且session过期
                    response.setHeader("sessionstatus", "timeout");
                } else {
                    //进入登录页【转发】
                    request.getRequestDispatcher("/login").forward(request, response);
                }
                return false;
            }

            return true;
        }
    }

    /**
     * 判断访问类型是否为ajax
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String headerX = request.getHeader("X-Requested-With");
        return headerX != null && headerX.equalsIgnoreCase("XMLHttpRequest");
    }

}
