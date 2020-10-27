package com.glaway.myspringboot.aop;

import com.glaway.myspringboot.utils.ResultVoUtil;
import com.glaway.myspringboot.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 *       测试aspect 2.1.5 spring boot
	 *
	 *       before path:/aspet
	 *   	 before className:com.glaway.myspringboot.aop.MyAspectController
	 *       before methodName:aspect
	 *       before paraName and args:{message=null}
	 *       aspect controller....
	 *       after methodName:aspect
	 *       afterReturning methodName:aspect, returning:ResultVo(code=1, message=成功, data=null)
	 **/

	@GetMapping
    public ResultVo<String> aspect(String message) {
		log.info("aspect controller....");
		return ResultVoUtil.success("aaa");
	}

	/**
	 * @author 		   FZH
	 * @date 		   2020/9/14
	 * @parameter 	   []
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<java.lang.String>
	 * @description
	 * 		测试 afterThrowing 2.1.5 spring boot
	 *       before path:/aspet/exception
	 *       before className:com.glaway.myspringboot.aop.MyAspectController
	 *       before methodName:exception
	 *       before paraName and args:{}
	 *       exception controller......
	 *       after methodName:exception
	 *       afterThrowing methodName : exception , throw message : exception.....
	 **/
	// @GetMapping("/exception")
	public ResultVo<String> exception() {
		log.info("exception controller......");
		throw new RuntimeException("exception.....");
	}

	/**
	 * @author 		   FZH
	 * @date 		   2020/9/14
	 * @parameter 	   [time]
	 * @return 		   com.glaway.myspringboot.vo.ResultVo<java.lang.String>
	 * @description
	 *		测试around
	 *	time != 1000
	 *        around : begin
	 *        sleep....
	 *        around : execute time = -18
	 *        around : return value = ResultVo(code=1, message=成功, data=wake up)
	 *        around end
	 *
	 *	time=1000
	 *        around : begin
	 *        sleep....
	 *        around error:sleep exception.
	 **/
	@GetMapping("/sleep/{time}")
	public ResultVo<String> sleep(@PathVariable("time") long time) {
		log.info("sleep....");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.info("sleep");
		}
		if(time == 1000) {
			throw new RuntimeException("sleep exception.");
		}
		return ResultVoUtil.success("wake up");
	}


}
