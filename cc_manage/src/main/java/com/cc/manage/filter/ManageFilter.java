package com.cc.manage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * 管理端过滤器
 * @author wlc
 */
@Component
public class ManageFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 数字越大，优先级越低
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 是否执行该过滤器
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 在这里可以进行权限验证、数据转发、日志处理等等。。。暂时不做了，jwt那块略过了。
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		System.out.println("进来了manage的zuul过滤器...");
		return null;
	}
}
