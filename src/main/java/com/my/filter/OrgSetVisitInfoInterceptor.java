package com.my.filter;

import com.my.frame.model.SysOrg;
import com.my.frame.service.SysOrgService;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	设置访问信息拦截器
 * @author whm
 * @date 2018/7/27
 */
public class OrgSetVisitInfoInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysOrgService orgService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //站点前缀字符串——地址
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));

        //如果没有前缀
        if(prefix_orgCd.length() <= 0){
            //设置前缀为root
            prefix_orgCd = "root";
        }

        //获取该站点的名称和首页地址和使用的样式库
        SysOrg sysOrg = orgService.getByUniqueKey("orgCd", prefix_orgCd, SysOrg.class);
        if(sysOrg != null){
            request.setAttribute("prefix_orgNm", sysOrg.getOrgNm());
            request.setAttribute("prefix_orgStyleLib", sysOrg.getOrgStylelib());
            request.setAttribute("prefix_orgLayoutLib", sysOrg.getOrgLayoutlib());
        }

        //继续进行
        return true;
    }
}
