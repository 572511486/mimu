package com.glaway.myspringboot.testenum;

/**
 * @filename:       Sex
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         ZF
 * @createtime:     2020年08月20日16:42
 * @description:   
 *                      
 */
public enum Sex {
	//男，女，未知
	MALE("男"){},FEMAL("女"){},UNKNOWN("未知"){};

	private String sexName;

	Sex() {
	}
	Sex(String sexName) {
		this.sexName = sexName;
	}

	public String getSexName() {
		return sexName;
	}

}
