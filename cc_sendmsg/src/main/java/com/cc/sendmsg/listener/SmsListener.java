package com.cc.sendmsg.listener;

import com.cc.sendmsg.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 发送短信mq监听服务
 * @author wlc
 */
@RabbitListener(queues = {"cc_sms"})
@Component
public class SmsListener {

	@Autowired
	private SmsUtil smsUtil;
	/**模板编号*/
	@Value("${aliyun.sms.template_code}")
	private String template_code;
	/**签名*/
	@Value("${aliyun.sms.sign_name}")
	private String sign_name;

	@RabbitHandler
	public void sendSms(Map<String,Object> map){
		String mobile = (String)map.get("mobile");
		String code = (String)map.get("code");
		System.out.println("mobile:"+mobile+",code:"+code);
		try {
			String a = "a"+code+"";
			//需要是json串类型，key对应template_code中设置的变量
			String param = "{\"code\":\""+code+"\"}";
			smsUtil.sendSmsNew(mobile,sign_name,template_code,param);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
