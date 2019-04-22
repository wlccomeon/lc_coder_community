package com.cc.gathering;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import com.lc.util.IdWorker;

/**
 * 活动详情服务启动器
 * @author wlc
 * @EnableCaching 启动spring的本地缓存支持
 */
@EnableCaching
@SpringBootApplication
public class GatheringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatheringApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
