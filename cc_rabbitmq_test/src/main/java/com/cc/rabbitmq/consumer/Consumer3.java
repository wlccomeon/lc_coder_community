package com.cc.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "cc_queue3")
public class Consumer3 {

	@RabbitHandler
	private void consumeMsg(String msg){
		System.out.println("接收到cc_queue3消息："+msg);
	}

}
