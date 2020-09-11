package com.glaway.myspringboot.vo;

import lombok.Data;

/**
 * @filename:       ResultVo
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月11日14:12
 * @description:   
 *          Result View Object
 */
@Data
public class ResultVo<T> {
	private Integer code;
	private String message;
	private T data;
}
