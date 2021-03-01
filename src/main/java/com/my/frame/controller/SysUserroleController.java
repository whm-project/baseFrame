package com.my.frame.controller;

import com.my.frame.service.SysUserroleService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author
 * @version 0.0.1
 * @date 2018/08/23
 * @time 09:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysUserrole*")
public class SysUserroleController {

    @Autowired
    private SysUserroleService sysUserroleService;

}
