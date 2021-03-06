package com.cc.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbitmq消费者
 * @author wlc
 */
@RabbitListener(queues = "cc_queue")
@Component
public class Consumer {

	@RabbitHandler
	private void consumeMsg(String msg){
		System.out.println("接收到cc_queue消息："+msg);
	}

}
