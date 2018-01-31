package com.zxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zxy.dao.ProductInfoDAO;
import com.zxy.entity.ProductInfo;
import com.zxy.enums.ProductStatusEnum;
import com.zxy.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

	@Autowired
	private ProductInfoDAO dao;

	@Override
	public ProductInfo findOne(String ProductId) {
		return dao.findOne(ProductId);
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return dao.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return dao.save(productInfo);
	}
	
	

}
