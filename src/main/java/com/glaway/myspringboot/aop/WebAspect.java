package com.glaway.myspringboot.aop;

import com.glaway.myspringboot.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @filename:       WebAspect
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         FZH
 * @createtime:     2020年09月11日14:09
 * @description:   
 *      WebAspect Advice
 */
@Aspect
@Slf4j
// @Component
public class WebAspect {
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
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
		Object[] args = joinPoint.getArgs();

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		for (int i = 0; i < parameterNames.length; i++) {
			paramMap.put(parameterNames[i],args[i]);
		}
		log.info("before path:{}",request.getServletPath());
		log.info("before className:{}",className);
		log.info("before methodName:{}",methodName);
		log.info("before paraName and args:{}",paramMap.toString());
	}

	@After(value = "pointCut()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		log.info("after methodName:{}",methodName);
	}

	@AfterReturning(value = "pointCut()",returning = "returning")
	public void afterReturning(JoinPoint joinPoint,Object returning) {
		log.info("afterReturning methodName:{}, returning:{}",joinPoint.getSignature().getName(),returning);
	}

	@AfterThrowing(value = "pointCut()",throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		log.info("afterThrowing methodName : {} , throw message : {}",joinPoint.getSignature().getName(),e.getLocalizedMessage());
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		long begin = System.currentTimeMillis();
		log.info("around : begin");
		Object proceed = null;
		try {
			 // 调用目标方法
			 proceed = joinPoint.proceed();
		} catch (Throwable throwable) {
			log.info("around error:{}",throwable.getMessage());
			return ResultVoUtil.error(throwable.getMessage());
		}
		long end = System.currentTimeMillis();
		log.info("around : execute time = {}", end - begin);
		log.info("around : return value = {}",proceed);
		log.info("around end");
		return proceed;
	}
}
