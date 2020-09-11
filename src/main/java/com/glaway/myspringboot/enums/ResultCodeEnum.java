package com.glaway.myspringboot.enums;

import lombok.Getter;

/**
 * @filename:       ResultCodeEnum
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月11日14:14
 * @description:   
 *        Result View Object Code Enum
 */
@Getter
public enum ResultCodeEnum {
	//code 状态码  message:消息内容
	SUCCESS(1,"成功"),
	ERROR(0,"失败")
	;

	private final Integer code;
	private final String message;

	ResultCodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
