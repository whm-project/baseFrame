package com.my.filter;

import com.my.commonEnum.StatusEnum;
import com.my.frame.model.SysOrg;
import com.my.frame.service.SysOrgService;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	站点权限拦截
 * @author whm
 * @date 2018/6/13
 */
public class OrgPermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysOrgService orgService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //controller访问的相对路径
        String contextPath = request.getContextPath();

        //站点前缀字符串——地址
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        String org_prefix_path = "/" + prefix_orgCd;

        //当前用户站点
        String userOrgCd = StringUtil.notNull(request.getSession().getAttribute("userOrgCd"));
        //查询要访问的站点
        SysOrg visitOrg = orgService.getByUniqueKey("orgCd", prefix_orgCd, SysOrg.class);

        //如果查不到要访问的站点，返回没有权限
        if(visitOrg == null){
            request.setAttribute("msg", "访问组织不存在！");
            //进入错误页【转发】
            request.getRequestDispatcher("/error/authorityError").forward(request, response);
            return false;
        }

        //查到要访问的站点了，判断是不是正常状态，不正常提示
        Integer orgStatus = visitOrg.getOrgStatus();
        if(null == orgStatus || orgStatus.equals(StatusEnum.NOUSED.getValue())){
            request.setAttribute("msg", "访问组织不在用！");
            //进入错误页【转发】
            request.getRequestDispatcher("/error/authorityError").forward(request, response);
            return false;
        }

        //查到要访问的站点了，判断是不是公司，如果不是公司，无法管理
        Integer orgType = visitOrg.getOrgType();
        if(null==orgType || !orgType.equals(SysOrg.OrgTypeEnum.COMPANY.getValue())){
            request.setAttribute("msg", "访问组织不是公司！");
            //进入错误页【转发】
            request.getRequestDispatcher("/error/authorityError").forward(request, response);
            return false;
        }

        //如果当前用户站点就是要访问的站点，直接跳过
        if(userOrgCd.equals(prefix_orgCd)){
            return true;
        }

        //可以管理的站点
        String visitOrgIndex = StringUtil.notNull(visitOrg.getOrgIndex());

        //如果在管理范围内
        if(visitOrgIndex.contains(userOrgCd)){
            return true;
        }
        //如果不在管理范围内
        else{
            request.setAttribute("msg", "访问组织不是您管理的！");
            //进入错误页【转发】
            request.getRequestDispatcher("/error/authorityError").forward(request, response);
            return false;
        }
    }
}
