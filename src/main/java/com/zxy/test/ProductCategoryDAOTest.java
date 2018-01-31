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
import com.zxy.dao.ProductCategoryDAO;
import com.zxy.entity.ProductCategory;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SellApplication.class)
public class ProductCategoryDAOTest {

	@Autowired
	private ProductCategoryDAO dao;
	
	@Test	//测试查一个
	public void findOneTest() {
		ProductCategory findOne = dao.findOne(1);
		System.out.println(findOne);
	}
	@Test		//测试修改
	public void updateTest() {
		ProductCategory productCategory = dao.findOne(4);
		productCategory.setCategoryName("现代wenxue");
		productCategory.setCategoryType(4);
		dao.save(productCategory);
	}
	
	@Test	//测试添加
	@Transactional
	public void saveTest() {
		ProductCategory productCategory = new ProductCategory("测试类目", 99);
		ProductCategory result = dao.save(productCategory);
		Assert.assertNotNull(result);
		//Assert.assertNotEquals(null,result);  //与上一行等效（不期望是null,期望是result）
	}

	@Test	//测试多选查询
	public void findByCategoryTypeInTest() {
		List<Integer> list = Arrays.asList(2,3,4);
		List<ProductCategory> result = dao.findByCategoryTypeIn(list);
		Assert.assertNotEquals(0, result.size());
	}
}
