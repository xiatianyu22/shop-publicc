package com.shop.online.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.shop.online.core.Command;
import com.shop.online.core.Meta;

public class HandleFactory {
	private static final String JOIN_CHAR = ".";
	private static Map<String, Command> commandMap = Collections.synchronizedMap(new HashMap<String, Command>());
	
	public static Command getCommand(Meta meta, String servicePath){
		String key = StringUtils.replace(servicePath, "/", JOIN_CHAR);
		StringBuilder sb = new StringBuilder();
		sb.append(key).append(JOIN_CHAR).append(meta.getCountryCode()).append(JOIN_CHAR).append(meta.getVersion());
		Command command = commandMap.get(sb.toString());
		if(command == null) {
			command = SpringContextUtil.getBean(sb.toString(), Command.class);
		}
		if(command == null) {
			command = SpringContextUtil.getBean(key + JOIN_CHAR + meta.getCountryCode(), Command.class);
		}
		if(command == null) {
			command = SpringContextUtil.getBean(key + JOIN_CHAR + meta.getVersion(), Command.class);
		}
		if(command == null) {
			command = SpringContextUtil.getBean(key, Command.class);
		}
		if(command != null) {
			commandMap.put(sb.toString(), command);
		}
		return command;
	}

}
