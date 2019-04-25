package com.cc.search;

import com.lc.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 搜索微服务
 * @author wlc
 */
@SpringBootApplication
public class SearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class,args);
	}

	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1,1);
	}
}
