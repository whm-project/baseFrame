package com.my.frame.dao;

import com.my.base.BaseDao;
import com.my.frame.model.SysMenu;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;

import java.util.List;

public interface SysUsermenuDao extends BaseDao<SysUsermenu> {

    List<SysMenu> getUserMenuList(SysUsermenuQueryModel usermenuQueryModel);

}