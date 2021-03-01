package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.base.SearchTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.frame.dao.SysLogConfigDao;
import com.my.frame.service.SysLogConfigService;
import com.my.frame.model.SysLogConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * @author
 * @version 0.0.1
 * @date 2019/11/28
 * @time 15:12
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLogConfigServiceImpl extends BaseServiceImpl<SysLogConfig> implements SysLogConfigService  {

    @Autowired
    private SysLogConfigDao sysLogConfigDao;

}
