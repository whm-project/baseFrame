package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysUsermenuDao;
import com.my.frame.model.SysMenu;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;
import com.my.frame.service.SysUsermenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUsermenuServiceImpl extends BaseServiceImpl<SysUsermenu> implements SysUsermenuService {

    @Autowired
    private SysUsermenuDao sysUsermenuDao;

    /**
     * 根据条件查询用户菜单
     * @param usermenuQueryModel
     * @return
     */
    @Override
    public List<SysMenu> getUserMenuList(SysUsermenuQueryModel usermenuQueryModel) {
        return sysUsermenuDao.getUserMenuList(usermenuQueryModel);
    }
}
