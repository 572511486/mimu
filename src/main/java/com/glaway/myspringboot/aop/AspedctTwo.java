package com.glaway.myspringboot.aop;

import com.glaway.myspringboot.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @filename:       AspedctTwo
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月14日10:29
 * @description:   
 *         测试同一切面的执行顺序
 *         aspectTwo around begin
 *         aspectTwo before
 *         sleep....
 *         aspectTwo around end
 *         aspectTwo after
 *         aspectTwo afterReturning
 */
@Slf4j
@Aspect
@Component
@Order(2)
public class AspedctTwo {
	/**
	 * @author 		   FZH
	 * @date 		   2020/9/11
	 * @parameter 	   []
	 * @return 		   void
	 * @description
	 *    Pointcut 用来定义切点；
	 *    execution 是用来匹配连接点的执行方法；
	 *    public 代表要匹配访问权限为 public 的方法；
	 *    第一个 * 代表返回值为任意类型；
	 *    com.imooc.springboot.aop 为包路径；
	 *    第二个 * 代表前面包路径下的任意类；
	 *    第三个 * 代表任意方法；
	 *    (…) 代表任意参数。
	 *    三个 * 可以换成具体的类或者方法。
	 **/
	@Pointcut("execution(public * com.glaway.myspringboot.aop.*.*(..))")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before(JoinPoint joinPoint) {
		log.info("aspectTwo before");
	}

	@After(value = "pointCut()")
	public void after(JoinPoint joinPoint) {
		log.info("aspectTwo after");
	}

	@AfterReturning(value = "pointCut()",returning = "returning")
	public void afterReturning(JoinPoint joinPoint,Object returning) {
		log.info("aspectTwo afterReturning");
	}

	@AfterThrowing(value = "pointCut()",throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		log.info("aspectTwo afterThrowing");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		long begin = System.currentTimeMillis();
		log.info("aspectTwo around begin");
		Object proceed = null;
		try {
			// 调用目标方法
			proceed = joinPoint.proceed();
		} catch (Throwable throwable) {
			log.info("around error:{}",throwable.getMessage());
			return ResultVoUtil.error(throwable.getMessage());
		}
		log.info("aspectTwo around end");
		return proceed;
	}
}
