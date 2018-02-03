package com.zxy.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.dao.OrderDetailDAO;
import com.zxy.entity.OrderDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class OrderDetailDAOTest {

	@Autowired
	private OrderDetailDAO dao;
	
	@Test 
	public void testSave(){
		OrderDetail detail = new OrderDetail();
		detail.setDetailId("65432101");
		detail.setOrderId("123456");
		detail.setProductIcon("http:xxx.jpg");
		detail.setProductId("114");
		detail.setProductName("西游记");
		detail.setProductPrice(new BigDecimal(88.88));
		detail.setProductQuantity(1);
		OrderDetail result = dao.save(detail);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testFindByOrderId() {

		List<OrderDetail> result = dao.findByOrderId("123456");
		Assert.assertNotEquals(0, result.size());
		
	}

}
