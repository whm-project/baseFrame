package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysParameterDao;
import com.my.frame.model.SysParameter;
import com.my.frame.service.SysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author
 * @version 0.0.1
 * @date 2019/05/24
 * @time 10:13
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysParameterServiceImpl extends BaseServiceImpl<SysParameter> implements SysParameterService {

    @Autowired
    private SysParameterDao sysParameterDao;

}
