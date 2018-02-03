package com.zxy.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.dao.OrderMasterDAO;
import com.zxy.entity.OrderMaster;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class OrderMasterDAOTest {

	private static final String OPENID = "110110";
	@Autowired
	private OrderMasterDAO dao;
	
	@Test
	public void testSave() {
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("1234567");
		orderMaster.setBuyerName("youling");
		orderMaster.setBuyerPhone("888888888");
		orderMaster.setBuyerAddress("银河系地球");
		orderMaster.setBuyerOpenid(OPENID);
		orderMaster.setOrderAmount(new BigDecimal(888.88));
		
		OrderMaster result = dao.save(orderMaster);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testFindByBuyerOpenid() {
		PageRequest pageRequest = new PageRequest(0,1);
		Page<OrderMaster> result = dao.findByBuyerOpenid(OPENID, pageRequest);
		/*System.out.println("size= "+result.getSize());
		System.out.println("content= "+result.getContent());
		System.out.println("totalPages= "+result.getTotalPages());
		System.out.println("totalElements= "+result.getTotalElements());
		System.out.println("sort= "+result.getSort());
		System.out.println("number= "+result.getNumber());
		System.out.println("numberOfElements= "+result.getNumberOfElements());*/
		Assert.assertNotEquals(0, result.getSize());
	}

}
