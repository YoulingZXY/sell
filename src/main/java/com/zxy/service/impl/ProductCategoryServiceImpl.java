package com.zxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxy.dao.ProductCategoryDAO;
import com.zxy.entity.ProductCategory;
import com.zxy.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDAO categoryDao;
	
	@Override
	public ProductCategory findOne(Integer categoryId) {
		return categoryDao.findOne(categoryId);
	}

	@Override
	public List<ProductCategory> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categotyTypeList) {
		return categoryDao.findByCategoryTypeIn(categotyTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return categoryDao.save(productCategory);
	}

}
