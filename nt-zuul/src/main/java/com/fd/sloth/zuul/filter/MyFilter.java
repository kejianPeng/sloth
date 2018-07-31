package com.fd.sloth.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * <b>filterType: 返回一个字符串代表过滤器的类型，在 zuul 中定义了四种不同生命周期的过滤器类型，具体如下:</b>
 * <li>pre：路由之前</li>
 * <li>routing：路由之时</li>
 * <li>error：发送错误调用</li>
 * <li>filterOrder：过滤的顺序</li>
 * <li>shouldFilter：这里可以写逻辑判断，是否要过滤</li>
 * <li>run：过滤器的具体逻辑。可用很复杂，包括查 sql, nosql 去判断该请求到底有没有权限访问</li>
 * 
 * @author FD.PENG
 * @date : 2018-07-31
 */
@Component
public class MyFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		logger.info("ok");
		return null;
	}

}
