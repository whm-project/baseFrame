package com.my.frame.controller;

import com.my.frame.model.SysMenu;
import com.my.frame.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 框架controller
 * @author whm
 * @date 2018/7/27
 */
@Controller
@RequestMapping("/frame*")
public class FrameController {

    @Autowired
    private SysMenuService menuService;

    @RequestMapping(method = RequestMethod.GET)
    public String showFrame(){
        return "frame1";
    }

    /**
     * 显示该菜单页面
     * @param menuCd
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "showMenuPage", method = RequestMethod.GET)
    public String shoMenuPage(
            @RequestParam(required = true) String menuCd,
            ModelMap modelMap){
        modelMap.put("menuInfo", menuService.getByUniqueKey("menuCd", menuCd, SysMenu.class));
        return "contentPage";
    }

    /**
     * 显示自定义页面
     * @param pageStr
     * @return
     */
    @RequestMapping(value = "showCustomPage", method = RequestMethod.GET)
    public String shoCustomPage(
            @RequestParam(required = true) String pageStr,
            @RequestParam(required = false) String params,
            ModelMap modelMap
    ){
        modelMap.put("params", modelMap);
        return pageStr;
    }

}
