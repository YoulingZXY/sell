package com.zxy.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * 
 * @author 闻人羽
 *
 */
@Component	//普通JAVA类要加此注解才能被正确装配注入
public class KeyUtil {
	
	/**
	 * 用于生成唯一的主键
	 * 格式：时间+6为随机数
	 * @return
	 */
	public static synchronized String getUniqueKey() {
		Random random = new Random();
		Integer number = random.nextInt(900000) + 100000;
		return System.currentTimeMillis() + String.valueOf(number);
	}
}
