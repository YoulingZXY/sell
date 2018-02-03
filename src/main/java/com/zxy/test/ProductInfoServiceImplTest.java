package com.zxy.test;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.dto.CartDTO;
import com.zxy.entity.ProductInfo;
import com.zxy.enums.ProductStatusEnum;
import com.zxy.service.impl.ProductInfoServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class ProductInfoServiceImplTest {
	
	@Autowired
	private ProductInfoServiceImpl service;

	@Test
	public void testFindOne() {
		ProductInfo result = service.findOne("123456");
		Assert.assertEquals("123456", result.getProductId());
	}

	@Test
	public void testFindUpAll() {
		List<ProductInfo> result = service.findUpAll();
		Assert.assertNotEquals(0, result.size());
	}

	@Test
	public void testFindAll() {
		Page<ProductInfo> page = service.findAll(new PageRequest(0, 3));
		System.out.println("~~~~~~"+page.getTotalElements()+"~~~~~~~~");
		Assert.assertNotEquals(0, page.getTotalElements());
	}

	@Test
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setCategoryType(2);
		productInfo.setProductDescription("神来之笔");
		productInfo.setProductIcon("http://xxxx.png");
		productInfo.setProductId("123457");
		productInfo.setProductName("权力的游戏");
		productInfo.setProductPrice(new BigDecimal(888.88));
		productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
		productInfo.setProductStock(10);
		ProductInfo result = service.save(productInfo);
		Assert.assertNotNull(result);
	}
	
	@Test
	@Transactional
	public void testDecreaseStock() {
		List<CartDTO> cartDTOList = Arrays.asList(new CartDTO("111",1),new CartDTO("112",1));
		service.decreaseStock(cartDTOList);
	}

}
