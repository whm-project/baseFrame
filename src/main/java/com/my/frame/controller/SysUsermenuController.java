package com.my.frame.controller;

import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysMenu;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;
import com.my.frame.service.SysUsermenuService;
import com.my.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @author
 * @version 0.0.1
 * @date 2019/01/04
 * @time 15:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysUsermenu*")
public class SysUsermenuController {

    @Autowired
    private SysUsermenuService sysUsermenuService;

    /**
     * 获取用户所能使用的菜单，默认查询当前用户的所有权限
     * @param usermenuQueryModel
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getUserMenuList", method = RequestMethod.GET)
    @ResponseBody
    public List<SysMenu> getUserMenuList(
            SysUsermenuQueryModel usermenuQueryModel,
            HttpServletRequest request, HttpServletResponse response
    ){
        //如果userCd为空，默认为当前登录用户
        if(StringUtil.notNull(usermenuQueryModel.getUserCd()).equals("")){
            usermenuQueryModel.setUserCd(StringUtil.notNull(request.getSession().getAttribute("userCd")));
        }
        //获取用户相关的菜单
        List<SysMenu> resultList = sysUsermenuService.getUserMenuList(usermenuQueryModel);

        //返回
        return resultList;
    }

    /**
     * 保存用户权限
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "save_userMenu", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel save_userMenu(
            @RequestParam(value = "menuCdAry", required = false, defaultValue = "") String menuCdAryStr,
            @RequestParam(value = "userCd", required = true) String userCd,
            HttpServletRequest request, HttpServletResponse response
    ){
        //都有值，进行保存
        if(!userCd.equals("")){
            //先删除之前的权限
            sysUsermenuService.deleteByProperty("userCd", userCd, SearchTypeEnum.EQ.getValue(), SysUsermenu.class);

            //增加现在的权限
            String[] menuCdAry = menuCdAryStr.split(",");
            SysUsermenu usermenu = new SysUsermenu();
            usermenu.setUserCd(userCd);
            for(String menuCd : menuCdAry){
                if(!menuCd.equals("")){
                    usermenu.setMenuCd(menuCd);
                    sysUsermenuService.save(usermenu);
                }
            }

            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
        }
        //传递值有缺失，提示
        else{
            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "用户信息缺失，请检查！");
        }
    }

}
