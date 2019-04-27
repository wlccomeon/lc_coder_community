package com.cc.qa.client.impl;

import com.cc.qa.client.LabelClient;
import com.lc.entity.Result;
import org.springframework.stereotype.Component;

/**
 * 熔断机制，对labelClient接口不通情况下进行处理
 * @author wlc
 */
@Component
public class LabelClientImpl implements LabelClient {

	@Override
	public Result findById(String id) {
		return Result.createByError("熔断器启动了,可以对失败的业务进行处理。");
	}
}
