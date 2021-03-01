package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysRolemenuDao;
import com.my.frame.model.SysRolemenu;
import com.my.frame.service.SysRolemenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRolemenuServiceImpl extends BaseServiceImpl<SysRolemenu> implements SysRolemenuService {

    @Resource
    private SysRolemenuDao sysRolemenuMapper;

}
