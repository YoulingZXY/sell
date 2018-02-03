package com.zxy.service;

import java.util.List;

import com.zxy.entity.ProductCategory;

public interface ProductCategoryService {

	/***/
	ProductCategory findOne(Integer categoryId);
	
	/***/
	List<ProductCategory> findAll();

	/***/
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	
	/***/
	ProductCategory save(ProductCategory productCategory);

}
