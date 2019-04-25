package com.lc.cc.base;

import com.lc.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * springboot启动器
 * @author wlc
 */
@SpringBootApplication
public class LabelApplication {

	public static void main(String[] args){
		SpringApplication.run(LabelApplication.class,args);
	}

	/**将bean纳入spring管理*/
	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1,1);
	}

}
