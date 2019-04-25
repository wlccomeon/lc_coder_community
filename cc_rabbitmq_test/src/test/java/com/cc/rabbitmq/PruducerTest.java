package com.cc.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class PruducerTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void testSendMsg(){
		rabbitTemplate.convertAndSend("cc_queue","测试mq消息2");
	}

}
