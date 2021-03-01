package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysImgDao;
import com.my.frame.model.SysImg;
import com.my.frame.service.SysImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author
 * @version 0.0.1
 * @date 2019/03/16
 * @time 15:21
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysImgServiceImpl extends BaseServiceImpl<SysImg> implements SysImgService {

    @Autowired
    private SysImgDao sysImgDao;

    @Override
    public int mySave(SysImg img) {
        return sysImgDao.insertSelective(img);
    }
}
