package com.cc.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * web前台网关过滤器
 * @author wlc
 */
@Component
public class WebFilter extends ZuulFilter {
	@Override
	public String filterType() {
		//前置过滤器
		return "pre";
	}

	@Override
	public int filterOrder() {
		//优先级为0，数字越大，优先级越低
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		//是否执行该过滤器，这里设置为true
		return true;
	}

	/**
	 * 过滤器内执行的操作：return 任何 object的值都表示继续执行
	 * 如果想要不再执行，使用setsendzuulResponse(false);
	 * 在这里可以进行权限验证，日志操作，对header进行转发等等
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		System.out.println("进来了web端zuul网关过滤器...");
		//如果这里不对header进行转发，那么，接口端将会丢失请求头中的内容（因为在这个过滤器中被吞掉了）
		//向header中添加鉴权令牌
		RequestContext requestContext = RequestContext.getCurrentContext();
		//获取header
		HttpServletRequest request = requestContext.getRequest();
		//页面中添加的请求头信息，这里的key为authorization
		String authorization = request.getHeader("Authorization");
		if (authorization!=null){
			requestContext.addZuulRequestHeader("Authorization",authorization);
		}else{
			//可以设置不再转发，终止请求。
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(401);
		}
		return null;
	}
}
