package com.my.commonEnum;

public enum ModelEnum {
	
	/**
     *	 错误
     */
    ERROR("错误")
	,SYSUSER("用户")
	;
	
	private String name;
	
	ModelEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
