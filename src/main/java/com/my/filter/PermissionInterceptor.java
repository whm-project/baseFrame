package com.my.filter;

import com.my.frame.model.SysMenu;
import com.my.frame.model.querymodel.SysMenuQueryModel;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;
import com.my.frame.service.SysMenuService;
import com.my.frame.service.SysUsermenuService;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 	权限过拦截
 * @author whm
 * @date 2018/6/13
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysMenuService menuService;
    @Autowired
    private SysUsermenuService usermenuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //controller访问的相对路径
        String path=request.getServletPath();
        String contextPath = request.getContextPath();

        //站点前缀字符串——地址
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        String org_prefix_path = "/" + prefix_orgCd;

        //判断该链接有没有在权限控制之列
        SysMenuQueryModel menuQuery = new SysMenuQueryModel();
        menuQuery.setMenuUrl(path.substring(1));
        List<SysMenu> menuList = menuService.getMenuByQuery(menuQuery);

        //在控制中，判断是否有权限
        if(menuList.size() > 0){
            //取出session中用户cd
            String userCd = (String) request.getSession().getAttribute("userCd");

            //获取用户权限集合
            SysUsermenuQueryModel usermenuQueryModel = new SysUsermenuQueryModel();
            usermenuQueryModel.setUserCd(userCd);
            List<SysMenu> userMenuList = usermenuService.getUserMenuList(usermenuQueryModel);

            //判断用户权限中是否包含访问的链接
            for(SysMenu usermenu: userMenuList){
                String usermenuCd = usermenu.getMenuCd();
                for(SysMenu urlmenu: menuList){
                    //有一样的，有权限访问
                    if(usermenuCd.equals(urlmenu.getMenuCd())){
                        return true;
                    }
                }
            }

            if(isAjaxRequest(request)){
                response.setHeader("permissionStatus", "authorityError");
            }
            else{
                //循环完也没有一样的，没有权限访问【重定向】
                response.sendRedirect(contextPath + org_prefix_path + "/error/authorityError");
            }
            return false;
        }

        //不在控制中，默认有权限
        return true;
    }

    /**
     * 判断访问类型是否为ajax
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String headerX = request.getHeader("X-Requested-With");
        return headerX != null && headerX.equalsIgnoreCase("XMLHttpRequest");
    }
}
