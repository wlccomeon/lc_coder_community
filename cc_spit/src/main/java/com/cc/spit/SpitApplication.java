package com.cc.spit;

import com.lc.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 吐槽微服务启动器
 * @author wlc
 */
@SpringBootApplication
@EnableEurekaClient
public class SpitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpitApplication.class,args);
	}

	/**
	 * 引入id生成器
	 */
	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1,1);
	}

}
