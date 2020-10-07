package com.shop.online.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RegExUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ReqRespLoggerFilter implements Filter {
	private static final String REQUESTID = "requestId";
	private Logger logger = LoggerFactory.getLogger(ReqRespLoggerFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hr = (HttpServletRequest) request;
		HttpServletResponse hs = (HttpServletResponse)response;
		long startTime = System.currentTimeMillis();
		try {
			
			String randStr = RandomStringUtils.randomAlphanumeric(6);
			MDC.put(REQUESTID, randStr);
			
			BufferedRequestWrapper breq = new BufferedRequestWrapper(hr);
			BufferedResponseWrapper bres = new BufferedResponseWrapper(hs);
			
			logger.info(hr.getRequestURI() + " REST REQ: " + RegExUtils.replaceAll(breq.getRequestBody(), "(\r|\n)", ""));
			chain.doFilter(breq, bres);
			logger.info(hr.getRequestURI() + " REST RES: " + RegExUtils.replaceAll(bres.getResponseBody(), "(\r|\n)", ""));
			
			
		} finally {
			long endTime = System.currentTimeMillis();
			logger.info("SERVICES PROCESS REF: " + hr.getRequestURI()  + ", Duration: " + (endTime - startTime) + "ms");
			MDC.clear();
		}
		
		
	}

}
