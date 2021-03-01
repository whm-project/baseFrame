package com.my.commonEnum;

public enum OperationEnum {
	
	/**
     *	 未找到
     */
    NOEFOUND("未找到")
	,LOGIN("登录")
	,EXIT("退出")
	,BROWSE("浏览")

	;
	
	private String descript;
	
	OperationEnum(String descript) {
		this.descript = descript;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
