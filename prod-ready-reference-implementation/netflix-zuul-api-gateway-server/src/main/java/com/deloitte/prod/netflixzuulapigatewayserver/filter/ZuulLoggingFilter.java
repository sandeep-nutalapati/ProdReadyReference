package com.deloitte.prod.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	Logger logger= LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		// Logic for filter
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request uri {} ",request.getRequestURI());
		logger.info("request-> {} request uri-> {} ", request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// Do you want to apply this filter
		return true;
	}

	@Override
	public int filterOrder() {
		// When multiple filters order
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "Pre Filter";
	}

}
