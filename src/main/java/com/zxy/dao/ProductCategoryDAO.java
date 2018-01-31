package com.zxy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.ProductCategory;


public interface ProductCategoryDAO extends JpaRepository<ProductCategory,Integer>{
	
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
