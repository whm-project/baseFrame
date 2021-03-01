package com.my.frame.controller;

import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysRolemenu;
import com.my.frame.service.SysRolemenuService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author
 * @version 0.0.1
 * @date 2018/07/31
 * @time 15:12
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysRolemenu*")
public class SysRolemenuController {

    @Autowired
    private SysRolemenuService sysRolemenuService;

    /**
     * 获取角色已经拥有的权限
     * @param roleCd
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getRoleMenuList", method = RequestMethod.GET)
    @ResponseBody
    public List<SysRolemenu> getUserMenuList(
            @RequestParam(value = "roleCd", required = true) String roleCd,
            HttpServletRequest request, HttpServletResponse response
    ){
        return sysRolemenuService.findInfo("roleCd", roleCd, SearchTypeEnum.EQ.getValue(), "menuCd", SysRolemenu.class);
    }

    /**
     * 保存角色权限
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "save_roleMenu", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel save_roleMenu(
            @RequestParam(value = "menuCdAry", required = false, defaultValue = "") String menuCdAryStr,
            @RequestParam(value = "roleCd", required = true) String roleCd,
            HttpServletRequest request, HttpServletResponse response
    ){
        //都有值，进行保存
        if(!roleCd.equals("")){
            //先删除之前的权限
            sysRolemenuService.deleteByProperty("roleCd", roleCd, SearchTypeEnum.EQ.getValue(), SysRolemenu.class);

            //增加现在的权限
            String[] menuCdAry = menuCdAryStr.split(",");
            SysRolemenu rolemenu = new SysRolemenu();
            rolemenu.setRoleCd(roleCd);
            for(String menuCd : menuCdAry){
                if(!menuCd.equals("")){
                    rolemenu.setMenuCd(menuCd);
                    sysRolemenuService.save(rolemenu);
                }
            }

            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
        }
        //传递值有缺失，提示
        else{
            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "角色信息缺失，请检查！");
        }
    }

}
