package com.serendipity.cloud.server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * ErrorFilter
 *
 * @author Dongx
 * Description:
 * Created in: 2019-07-31 15:14
 * Modified by:
 */
@Slf4j
public class ErrorFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 100;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		log.error("this is a ErrorFilter: {}", throwable.getCause().getMessage());
		return null;
	}
}
