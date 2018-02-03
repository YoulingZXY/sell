package com.zxy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.ProductCategory;


public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer>{
	
	/**
	 * 通过类目编号(可多选，所以参数为集合)查询类目的详细信息
	 * @param categoryTypeList
	 * @return
	 */
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
