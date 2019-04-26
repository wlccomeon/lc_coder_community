package com.cc.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "cc_queue2")
public class Consumer2 {

	@RabbitHandler
	private void consumeMsg(String msg){
		System.out.println("接收到cc_queue2消息："+msg);
	}

}
