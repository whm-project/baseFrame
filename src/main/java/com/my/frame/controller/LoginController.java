package com.my.frame.controller;

import com.my.base.ResultViewModel;
import com.my.commonEnum.ModelEnum;
import com.my.commonEnum.OperationEnum;
import com.my.filter.LogAnnotation;
import com.my.frame.model.SysOrg;
import com.my.frame.model.SysUser;
import com.my.commonEnum.StatusEnum;
import com.my.frame.service.SysOrgService;
import com.my.frame.service.SysUserService;
import com.my.utils.CodeUtil;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author whm
 * @date 2018/7/3
 */
@Controller
@RequestMapping("/login*")
public class LoginController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysOrgService orgService;

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String login(
            HttpServletRequest request,
            ModelMap modelMap
    ){
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        modelMap.put("prefix_org", orgService.getByUniqueKey("orgCd", prefix_orgCd, SysOrg.class));
        return "login";
    }

    /**
     * 用户登录
     * @param code
     * @param loginName
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    @LogAnnotation(model = ModelEnum.SYSUSER,operation = OperationEnum.LOGIN)
    public ResultViewModel userLogin(
            @RequestParam(value = "code", required = true) String code,
            @RequestParam(value = "loginName", required = true) String loginName,
            @RequestParam(value = "password", required = true) String password,
            HttpServletRequest request, HttpServletResponse response
    ){
        ResultViewModel resultViewModel = new ResultViewModel();

        //验证码不为空
        Object codeObj = request.getSession().getAttribute("code");
        if(codeObj == null){
            resultViewModel.setState(ResultViewModel.StateEnum.ABNORMAL.getValue());
            resultViewModel.setMsg("验证码过期，请刷新验证码！");
            return resultViewModel;
        }

        //校验验证码
        if(!codeObj.toString().equalsIgnoreCase(code)) {
            resultViewModel.setState(ResultViewModel.StateEnum.ABNORMAL.getValue());
            resultViewModel.setMsg("验证码输入不正确！");
            return resultViewModel;
        }

        //设置验证码失效（验证码只可使用一次）
        request.getSession().removeAttribute("code");

        //数据库请求，验证用户名密码是否正确
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        SysUser user = userService.getUserInfo(loginName, password);

        //用户名密码正确
        if(user != null){
            //验证组织机构
            if(orgService.checkContainOrgCd(user.getOrgCd(), prefix_orgCd)){
                //如果状态可用，返回可用
                if(user.getUserStatus().equals(StatusEnum.USED.getValue())){
                    //userCd放入session
                    request.getSession().setAttribute("userCd", user.getUserCd());
                    //userNm放入session
                    request.getSession().setAttribute("userNm", user.getUserNm());
                    //userOrgCd放入session
                    request.getSession().setAttribute("userOrgCd", user.getOrgCd());
                    //userOrgIndex放入session
                    request.getSession().setAttribute("userOrgIndex", orgService.getByUniqueKey("orgCd", user.getOrgCd(), SysOrg.class).getOrgIndex());
                    //当前访问站点放入session
                    request.getSession().setAttribute("login_prefix_orgCd", StringUtil.notNull(request.getAttribute("prefix_orgCd")));

                    //返回信息
                    resultViewModel.setState(ResultViewModel.StateEnum.NORMAL.getValue());
                    resultViewModel.setMsg("");
                    return resultViewModel;
                }
            }
        }

        //返回信息
        resultViewModel.setState(ResultViewModel.StateEnum.ABNORMAL.getValue());
        resultViewModel.setMsg("用户名和密码不匹配或用户不可用！");
        return resultViewModel;
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
        // 将四位数字的验证码保存到Session中。
        request.getSession().setAttribute("code", codeMap.get("code").toString());

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);

        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "png", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    @LogAnnotation(model = ModelEnum.SYSUSER,operation = OperationEnum.EXIT)
    public void logout(HttpServletRequest request, HttpServletResponse response){
        //清空缓存
        request.getSession().invalidate();
        //跳转到登录页面【重定向】
        try {
            response.sendRedirect(request.getContextPath() + "/" + request.getAttribute("prefix_orgCd") + "/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
