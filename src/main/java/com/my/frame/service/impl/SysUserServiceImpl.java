package com.my.frame.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.base.BaseServiceImpl;
import com.my.base.SearchTypeEnum;
import com.my.frame.dao.SysUserDao;
import com.my.frame.model.SysUser;
import com.my.frame.model.querymodel.SysUserQueryModel;
import com.my.frame.model.viewModel.SysUserViewModel;
import com.my.frame.service.SysUserService;
import com.my.utils.EncryptUtil;
import com.my.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author
 * @version 0.0.1
 * @date 2018/07/27
 * @time 10:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Resource
    private SysUserDao sysUserMapper;

    /**
     * 设置盐加密
     * @param pwd
     * @return {salt:盐, pwd:加密后密码}
     */
    @Override
    public Map<String, String> setSaltPwd(String pwd) {
        Map<String, String> saltPwdMap = new HashMap<>();
        //盐字符串串
        String salt = StringUtil.getRandom6Pwd();
        saltPwdMap.put("salt", salt);
        //加密
        String salt_sha = EncryptUtil.encryptWithoutSalt(salt, "SHA");
        String pw_md5 = EncryptUtil.encryptWithSalt(pwd, salt_sha, "MD5");
        saltPwdMap.put("pwd", pw_md5);
        //返回
        return saltPwdMap;
    }

    /**
     * 根据用户名密码，获取用户信息
     * @param userCd
     * @param userPw
     * @return
     */
    @Override
    public SysUser getUserInfo(String userCd, String userPw){
        try{
            //userCd是主键，不会重复
            SysUser user = getByUniqueKey("userCd", userCd, SysUser.class);

            //有记录
            if(user != null){
                //数据库中加密后的密码
                String userPw_result = user.getUserPw();

                //给输入的密码加密
                String salt = StringUtil.notNull(user.getUserSalt());
                String salt_sha = EncryptUtil.encryptWithoutSalt(salt, "SHA");
                String pw_md5 = EncryptUtil.encryptWithSalt(userPw, salt_sha, "MD5");

                //对比两个密码，一致，用户名密码通过验证
                if(userPw_result.equals(pw_md5)){
                    return user;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户
     * @param userQueryModel
     * @return
     */
    @Override
    public PageInfo<SysUserViewModel> findPageInfo(SysUserQueryModel userQueryModel) {
        PageHelper.startPage(userQueryModel.getPageNumber(), userQueryModel.getPageSize());
        List<SysUserViewModel> pageResult=sysUserMapper.findPageInfo(userQueryModel);
        return new PageInfo<SysUserViewModel>(pageResult);
    }

    /**
     * 修改用户组织机构编码
     * @param old_orgCd
     * @param new_orgCd
     */
    @Override
    public void updateUserOrg(String old_orgCd, String new_orgCd) {
        List<SysUser> userList = findInfo("orgCd", old_orgCd, SearchTypeEnum.EQ.getValue(), "", SysUser.class);
        for(SysUser user : userList){
            user.setOrgCd(new_orgCd);
            updateByPrimaryKeySelective(user);
        }

    }
}
