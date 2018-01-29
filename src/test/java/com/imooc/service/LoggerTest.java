package com.imooc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.sell.SellApplication;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
@Slf4j
public class LoggerTest {

	//private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

	@Test
	public void test1() {
		String name = "lalala";
		String pass = "000000";
		/*logger.debug("debug~~~");
		logger.info("info~~~");
		logger.error("error~~~");*/
		log.debug("debug~~~");
		log.info("info~~~");
		log.error("error~~~");
		log.info("name={},pass={}",name,pass);
	}
}
