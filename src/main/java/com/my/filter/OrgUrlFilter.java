package com.my.filter;

import com.my.frame.model.SysOrg;
import com.my.frame.service.SysOrgService;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 站点地址拆分，过滤
 * @author whm
 * @date 2018/7/27
 */
public class OrgUrlFilter extends OncePerRequestFilter {

    private SysOrgService orgService;

    /**
     * 	不过滤的地址
     */
    private String[] ignoreUrlAry;

    public String[] getIgnoreUrlAry() {
        return ignoreUrlAry;
    }

    public void setIgnoreUrlAry(String[] ignoreUrlAry) {
        this.ignoreUrlAry = ignoreUrlAry;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String session_prefix_orgCd = StringUtil.notNull(request.getSession().getAttribute("login_prefix_orgCd"));

        //controller访问的相对路径
        String path=request.getServletPath().substring(1);

        //地址长度大于0【具体地址】
        if(path.length() > 0){
            //拆分路径，获取站点和具体的访问路径
            String[] pathAry = path.split("/");

            //如果在不过滤地址【静态等】中，不进行操作
            for (int p=0; p<pathAry.length; p++){
                for (int i=0; i<ignoreUrlAry.length; i++){
                    if(ignoreUrlAry[i].equals(pathAry[p])){
                        filterChain.doFilter(request, response);
                        return ;
                    }
                }
            }

            //orgService
            XmlWebApplicationContext cxt =(XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
            if(cxt != null && cxt.getBean("sysOrgServiceImpl") != null && orgService == null) {
                orgService = (SysOrgService) cxt.getBean("sysOrgServiceImpl");
            }

            //判断第一个字符是不是组织机构cd中的值
            SysOrg org = orgService.getByUniqueKey("orgCd", pathAry[0], SysOrg.class);
            //如果是，设置站点cd
            if(org != null){
                String prefix_orgCd = pathAry[0];

                //请求参数增加站点信息
                request.setAttribute("prefix_orgCd", prefix_orgCd);

                //用户登录的站点和要访问的不一样，需退出，重新登录
                if(session_prefix_orgCd.length() > 0 && !session_prefix_orgCd.equals(prefix_orgCd)){
                    //跳转【转发】
                    request.getRequestDispatcher("/login/logout").forward(request, response);
                    return ;
                }

                //设置跳转路径为不带站点cd的路径
                String dispatcher_path = path.substring(prefix_orgCd.length());

                //如果不带站点cd没有地址了，进登录页
                if(dispatcher_path.length() <= 0){
                    dispatcher_path = "/login";
                }

                //跳转【转发】
                request.getRequestDispatcher(dispatcher_path).forward(request, response);
            }
            //如果不是，应该进else的逻辑
            else{
                //请求参数增加站点信息
                if(session_prefix_orgCd.length() > 0){
                    request.setAttribute("prefix_orgCd", session_prefix_orgCd);
                    //跳转【转发】
                    request.getRequestDispatcher("/"+path).forward(request, response);
                }else{
                    request.setAttribute("prefix_orgCd", "root");
                    //跳转【转发】
                    request.getRequestDispatcher("/login").forward(request, response);
                }
            }
        }
        //缺省进入，进入root的登录
        else {
            //请求参数增加站点信息
            if(session_prefix_orgCd.length() > 0){
                request.setAttribute("prefix_orgCd", session_prefix_orgCd);
            }else{
                request.setAttribute("prefix_orgCd", "root");
            }
            //跳转【转发】
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

}
