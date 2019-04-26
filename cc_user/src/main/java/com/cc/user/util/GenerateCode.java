package com.cc.user.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * 生成验证码
 * @author wlc
 */
public class GenerateCode {

	/**
	 * 生成6位数字随机验证码
	 * @return
	 */
	public static String generateSMSCode(){
//		Random random = new Random();
//		//最大数
//		int max = 999999;
//		//最小数
//		int min = 100000;
//		//随机生成
//		int code = random.nextInt(max);
//		if (code<min){
//			code = code+min;
//		}
//		return code+"";
		return RandomStringUtils.randomNumeric(6);
	}

}
