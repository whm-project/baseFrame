package com.my.base;

import java.io.Serializable;

/**
 * @author whm
 * @date 2018/6/8
 */
public class BaseQueryModel implements Serializable {

    /**
     * 页数
     */
    private int pageNumber = 0;

    /**
     * 每页条数
     */
    private int pageSize = 10;

    /**
     * 排序
     */
    private String order = "";

    /**
     * 当前用户所属组织机构
     */
    private String currentOrgCd;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCurrentOrgCd() {
        return currentOrgCd;
    }

    public void setCurrentOrgCd(String currentOrgCd) {
        this.currentOrgCd = currentOrgCd;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
