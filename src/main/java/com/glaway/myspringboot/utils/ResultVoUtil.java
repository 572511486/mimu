package com.glaway.myspringboot.utils;

import com.glaway.myspringboot.enums.ResultCodeEnum;
import com.glaway.myspringboot.vo.ResultVo;

/**
 * @filename:       ResultUtil
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月11日14:19
 * @description:   
 *       Result View Object Util
 */
public class ResultVoUtil {
	
	/**
	 * @author 		   FZH   
	 * @date 		   2020/9/11
	 * @parameter 	   [data]
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<T> 
	 * @description		
	 *      成功状态
	 **/
    public static <T> ResultVo<T> success(T data) {
		return instance(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
	}

	/**
	 * @author 		   FZH
	 * @date 		   2020/9/11
	 * @parameter 	   [data]
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<T>
	 * @description
	 *     失败状态
	 **/
	public static <T> ResultVo<T> error(T data) {
    	return instance(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMessage(), data);
	}

	/**
	 * @author 		   FZH   
	 * @date 		   2020/9/11
	 * @parameter 	   [code, message, data]
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<T> 
	 * @description		
	 *      实例化返回数据对象
	 **/
	private static <T> ResultVo<T> instance(Integer code, String message, T data) {
		ResultVo<T> resultVo = new ResultVo<T>();
		resultVo.setCode(code);
		resultVo.setMessage(message);
		resultVo.setData(data);
		return resultVo;

	}
}
