package com.shop.online.aop;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.shop.online.core.Command;
import com.shop.online.core.Request;
import com.shop.online.util.HandleFactory;

@Aspect
@Component
@Order(5)
public class RestEndPointAspect {
	
	
	//@Before("execution(* com.zhazhapan.spring.springtest.chapter.one.aop.DemoMethodService.* (..))")
	public void resetEndPointAspect() {}
	

	@Around("execution(public * com.shop.online..*.endpoint.*.*(..))")
	public Object callCommand(ProceedingJoinPoint joinPoint)throws Throwable{
			long startTime = System.currentTimeMillis();
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath() + "/shop/";
			request.getServletPath();
			Optional<Object> pr = Arrays.stream(joinPoint.getArgs()).filter(p -> p instanceof Request).findFirst();
			if(pr.isPresent()) {
				Request req = (Request)pr.get();
				Command command = HandleFactory.getCommand(req.getMeta(), StringUtils.removeStart(uri, contextPath));
				return command.execute(req);
			}else {
				return joinPoint.proceed();
			}
	}
	

}
