package com.zxy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.ProductInfo;

public interface ProductInfoDAO extends JpaRepository<ProductInfo, String>{

	List<ProductInfo> findByProductStatus(Integer productStatus);
}
