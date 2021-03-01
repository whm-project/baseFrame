package com.my.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 	使执行后进的页面和上一个页面布局是一套【为多布局样式设计】
 * @author Administrator
 *
 */
@Component
@Aspect
public class LayoutAspect {
	
	@Around("execution(String com.my..controller.*.*(..))")
	public String doLog(ProceedingJoinPoint pjp) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		Object prefix_orgLayoutLib = request.getAttribute("prefix_orgLayoutLib");
		if(prefix_orgLayoutLib == null){
			prefix_orgLayoutLib = "";
		}

		try {
			Object proceed = pjp.proceed();
			return prefix_orgLayoutLib.toString()+"/"+proceed;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return prefix_orgLayoutLib.toString()+"/error/unknow";
		}
	}

}
