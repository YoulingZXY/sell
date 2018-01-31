package com.zxy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zxy.entity.ProductInfo;

public interface ProductInfoService {
	
	public ProductInfo findOne(String ProductId);

	/** 查询所有在架商品列表. */
	public List<ProductInfo> findUpAll();
	
	/** 分页查询. */
	public Page<ProductInfo> findAll(Pageable pageable);
	
	public ProductInfo save(ProductInfo productInfo);
	
	//加库存，下单后减少库存
	
	//加库存，取消订单后加库存
}
