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

	/**
	 * 直接模式测试
	 */
	@Test
	public void testSendDirectMsg(){
		rabbitTemplate.convertAndSend("cc_queue","测试mq消息2");
	}

	/**
	 * 分列模式测试
	 */
	@Test
	public void testSendFanoutMsg(){
		rabbitTemplate.convertAndSend("cc_exchange","","测试分列发送消息模式");
	}

	/**
	 * 以下3个为主题模式测试
	 */
	@Test
	public void testSendTopicMsg(){
		rabbitTemplate.convertAndSend("topictest","goods.log","主题模式");
	}

	@Test
	public void testSendTopicMsg2(){
		rabbitTemplate.convertAndSend("topictest","goods.aaa","主题模式");
	}

	@Test
	public void testSendTopicMsg3(){
		rabbitTemplate.convertAndSend("topictest","article.content.log","主题模式");
	}

}
