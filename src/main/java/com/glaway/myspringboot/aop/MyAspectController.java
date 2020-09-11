package com.glaway.myspringboot.aop;

import com.glaway.myspringboot.utils.ResultVoUtil;
import com.glaway.myspringboot.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @filename:       MyAspectController
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月11日14:08
 * @description:   
 *         AOP 控制器测试
 */
@Slf4j
@RestController
@RequestMapping("/aspet")
public class MyAspectController {
	
	/**
	 * @author 		   FZH   
	 * @date 		   2020/9/11
	 * @parameter 	   [message]
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<java.lang.String> 
	 * @description		
	 *       测试aspect
	 *
	 *       同一个AOP下执行顺序
	 *       before path:/aspet
	 * 		 before className:com.glaway.myspringboot.aop.MyAspectController
	 *    	 before methodName:aspect
	 * 		 before paraName and args:{message=1231}
	 * 		 aspect controller....
	 * 		 afterReturning methodName:aspect, returning:ResultVo(code=1, message=成功, data=1231)
	 * 		 after methodName:aspect
	 **/
	@GetMapping
    public ResultVo<String> aspect(String message) {
		log.info("aspect controller....");
		return ResultVoUtil.success(message);
	}

	@GetMapping("/exception")
	public ResultVo<String> exception() {
		log.info("exception controller......");
		throw new RuntimeException("exception.....");
	}


}
