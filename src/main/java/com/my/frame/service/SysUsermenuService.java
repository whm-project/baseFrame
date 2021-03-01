package com.my.frame.service;

import com.my.base.BaseService;
import com.my.frame.model.SysMenu;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;

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
public interface SysUsermenuService extends BaseService<SysUsermenu> {

    /**
     * 根据条件查询用户菜单
     * @param usermenuQueryModel
     * @return
     */
    List<SysMenu> getUserMenuList(SysUsermenuQueryModel usermenuQueryModel);

}
