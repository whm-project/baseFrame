package com.my.frame.model.viewModel;

import com.my.frame.model.SysUser;

import java.io.Serializable;

/**
 * @author whm
 * @date 2021/2/6
 */
public class SysUserViewModel extends SysUser implements Serializable {

    /**
     * 组织机构名称
     */
    private String orgNm;

    /**
     * 获取组织机构名称
     */
    public String getOrgNm() {
        return orgNm;
    }

    /**
     * 设置组织机构名称
     */
    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

}
