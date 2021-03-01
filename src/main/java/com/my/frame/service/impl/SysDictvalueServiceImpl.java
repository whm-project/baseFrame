package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysDictvalueDao;
import com.my.frame.model.SysDictvalue;
import com.my.frame.service.SysDictvalueService;
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
public class SysDictvalueServiceImpl extends BaseServiceImpl<SysDictvalue> implements SysDictvalueService {

    @Autowired
    private SysDictvalueDao sysDictvalueDao;

}
