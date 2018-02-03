package com.zxy.test;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.dto.OrderDTO;
import com.zxy.entity.OrderDetail;
import com.zxy.entity.OrderMaster;
import com.zxy.service.impl.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
@Slf4j
public class OrderServiceImplTest {
	
	private static final String BUYER_OPENID = "273324098";
	private static final String ORDER_ID = "1517546324243957547";
	@Autowired
	OrderServiceImpl service;

	@Test
	public void testCreate() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerAddress("银河系地球");
		orderDTO.setBuyerName("闻人羽");
		orderDTO.setBuyerOpenid(BUYER_OPENID);
		orderDTO.setBuyerPhone("1234567890");
		orderDTO.setOrderDetailList(Arrays.asList(new OrderDetail("113",2),new OrderDetail("114",2)));
		OrderDTO result = service.create(orderDTO);
		Assert.assertNotNull(result);
		log.info("创建订单	result={}",result);
	}

	@Test
	public void testFindOne() {
		
		OrderDTO result = service.findOne(ORDER_ID);
		log.info("查询单个订单	result={}",result);
		Assert.assertEquals(ORDER_ID, result.getOrderId());
	}

	@Test
	public void testFindList() {
		
		Page<OrderMaster> result = service.findList(BUYER_OPENID, new PageRequest(0, 2));
		Assert.assertNotEquals(0, result.getTotalElements());
	}

	@Test
	public void testCancle() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinish() {
		fail("Not yet implemented");
	}

	@Test
	public void testPaid() {
		fail("Not yet implemented");
	}

}
