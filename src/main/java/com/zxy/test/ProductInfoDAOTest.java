package com.zxy.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.dao.ProductInfoDAO;
import com.zxy.entity.ProductInfo;
import com.zxy.enums.ProductStatusEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class ProductInfoDAOTest {

	@Autowired
	private ProductInfoDAO dao;
	
	@Test
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setCategoryType(2);
		productInfo.setProductDescription("绝世大作");
		productInfo.setProductIcon("http://xxxx.jgp");
		productInfo.setProductId("123456");
		productInfo.setProductName("三国演义");
		productInfo.setProductPrice(new BigDecimal(88.88));
		productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
		productInfo.setProductStock(100);
		ProductInfo result = dao.save(productInfo);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> productInfoList = dao.findByProductStatus(0);
		Assert.assertNotEquals(0, productInfoList.size());
	}

}
