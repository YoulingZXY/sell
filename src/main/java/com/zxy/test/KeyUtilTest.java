package com.zxy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.utils.KeyUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class KeyUtilTest {

	@Autowired
	private KeyUtil keyutil;
	
	//private KeyUtil keyutil = new KeyUtil();
	
	@Test
	public void testGetUniqueKey() {
		System.out.println(keyutil.getUniqueKey());
	}
}
