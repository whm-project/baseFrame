package com.my.frame.service;

import com.github.pagehelper.PageInfo;
import com.my.frame.model.SysMenu;
import com.my.frame.model.querymodel.SysMenuQueryModel;
import com.my.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 0.0.1
 * @date 2018/07/28
 * @time 14:39
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
public interface SysMenuService extends BaseService<SysMenu> {

    /**
     * 根据查询条件，查询菜单集合【不分页】
     * @param sysMenuQueryModel
     * @return
     */
    List<SysMenu> getMenuByQuery(SysMenuQueryModel sysMenuQueryModel);

    /**
     * 根据查询条件，查询菜单集合【分页】
     * @param sysMenuQueryModel
     * @return
     */
    PageInfo<SysMenu> getMenuPageByQuery(SysMenuQueryModel sysMenuQueryModel);

    /**
     * 设置菜单是否是父节点
     * @param menu_cd
     */
    short setMenuIsParent(String menu_cd);

    /**
     * 更新节点cd，子节点的index需要一起修改【只修改下级，不改自己】
     * @param old_cd
     * @param new_cd
     * @param menuId        自己节点的id，为了不改自己
     */
    void updateCd(String old_cd, String new_cd, Long menuId);

    /**
     * 修改上级节点cd，两个相关的上级节点的是否是父级节点需要一起修改【只修改下级，不改自己】
     * @param old_sup_cd
     * @param new_sup_cd
     * @param cd
     * @param menuId        自己节点的id，为了不改自己
     */
    void updateSupCd(String old_sup_cd, String new_sup_cd, String cd, Long menuId);

    /**
     * 修改菜单，会判断是否修改上级菜单cd，是否修改了本级菜单cd
     * @param menu
     * @return  {newSupMenuCd: xxxx, oldSupMenuCd:xxxx}
     */
    Map<String, Object> updateSysMenu(SysMenu menu);
}
