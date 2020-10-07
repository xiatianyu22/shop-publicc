package com.shop.online.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ctx = context;
	}
	
	public static <T> T getBean(String id, Class<T> requiredType) {
		try {
			return ctx.getBean(id, requiredType);
		}catch(Exception e) {
			return null;
		}
	}

}
