package com.cc.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 管理后台的网关治理微服务--管理人员调用的网关服务
 * @author wlc
 */
@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
public class ManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class,args);
	}


}
