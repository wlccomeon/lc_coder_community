package com.cc.qa.client;

import com.cc.qa.client.impl.LabelClientImpl;
import com.lc.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用label微服务
 * 微服务的名称必须与label的application-name保持一致（不能包含下划线）
 * @author wlc
 */
@FeignClient(value = "cc-label",fallback = LabelClientImpl.class)
public interface LabelClient {
	/**
	 * pathVariable中必须指定参数名字，否则会报的错误
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/label/{id}")
	Result findById(@PathVariable("id") String id);
}
