package com.cc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.sql.SQLOutput;

/**
 * 前台服务网关治理微服务---普通用户调用的
 * @author wlc
 */
@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class,args);
	}
}
