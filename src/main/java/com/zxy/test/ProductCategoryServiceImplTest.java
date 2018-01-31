package com.zxy.test;


import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxy.SellApplication;
import com.zxy.entity.ProductCategory;
import com.zxy.service.impl.ProductCategoryServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class ProductCategoryServiceImplTest {

	@Autowired
	private ProductCategoryServiceImpl categoryService;
	
	@Test
	public void testFindOne() {
		ProductCategory result = categoryService.findOne(1);
		Assert.assertEquals(new Integer(1), result.getCategoryId()); //期待得到的查询结果跟测试数据一致
	}

	@Test
	public void testFindAll() {
		List<ProductCategory> result = categoryService.findAll();
		Assert.assertNotEquals(0, result.size());	//期待结果不等于0
	}

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
		Assert.assertNotEquals(0, result.size());
	}

	@Test
	@Transactional
	public void testSave() {
		ProductCategory result = categoryService.save(new ProductCategory("古典小说",5));
		Assert.assertNotNull(result);  //期待结果不等于Null
	}

}
