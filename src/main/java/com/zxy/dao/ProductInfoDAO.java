package com.zxy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.ProductInfo;

public interface ProductInfoDAO extends JpaRepository<ProductInfo, String>{

	/**
	 * 查询所有在架商品，参数传入的是商品状态码
	 * @param productStatus
	 * @return
	 */
	List<ProductInfo> findByProductStatus(Integer productStatus);
}
