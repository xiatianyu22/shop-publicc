package com.shop.online.framework.logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public final class LogHelper {
	
	private static final String PERFORMANCE_LOG = "SHOP-HOST-PERFORMANCE";
	
	private static Map<String, Logger> logMap = new ConcurrentHashMap<>();
	
	private static Logger getLogger(String name) {
		Logger logger = logMap.get(name);
		if(logger == null) {
			logger = LoggerFactory.getLogger(name);
			logMap.put(name, logger);
		}
		return logger;
	}
	
	private static void log(Logger logger, Level level, String format, Object...arguments) {
		switch (level) {
		case TRACE:
			logger.trace(format, arguments);
			break;
		case DEBUG:
			logger.debug(format, arguments);
			break;
		case INFO:
			logger.info(format, arguments);
			break;
		case WARN:
			logger.warn(format, arguments);
			break;
		case ERROR:
			logger.error(format, arguments);
			break;
		default:
			logger.info(format, arguments);
			break;
		}
	}
	
	private static void log(Logger logger, Level level, String msg, Throwable throwable) {
		switch (level) {
		case TRACE:
			logger.trace(msg, throwable);
			break;
		case DEBUG:
			logger.debug(msg, throwable);
			break;
		case INFO:
			logger.info(msg, throwable);
			break;
		case WARN:
			logger.warn(msg, throwable);
			break;
		case ERROR:
			logger.error(msg, throwable);
			break;
		default:
			logger.info(msg, throwable);
			break;
		}
	}
	
	public static void doPerformanceLog(String format, Object... arguments) {
		doLog(PERFORMANCE_LOG, Level.INFO, format, arguments);
	}
	
	public static void doLog(Class<?> clazz, String format, Object... arguments) {
		doLog(clazz, Level.INFO, format, arguments);
	}
	
	public static void doLog(Class<?> clazz, Level level, String format, Object... arguments) {
		Logger logger = getLogger(clazz.getName());
		log(logger, level, format, arguments);
	}
	
	public static void doLog(Class<?> clazz, Level level, String msg, Throwable throwable) {
		Logger logger = getLogger(clazz.getName());
		log(logger, level, msg, throwable);
	}
	
	public static void doLog(String name, String format, Object... arguments) {
		doLog(name, Level.INFO, format, arguments);
	}
	
	public static void doLog(String name, Level level, String format, Object... arguments) {
		Logger logger = getLogger(name);
		log(logger, level, format, arguments);
	}
	
	public static void doLog(String name, Level level, String msg, Throwable throwable) {
		Logger logger = getLogger(name);
		log(logger, level, msg, throwable);
	}
	
	
	
	

}
