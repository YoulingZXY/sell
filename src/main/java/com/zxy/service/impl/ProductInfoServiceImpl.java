package com.zxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.dao.ProductInfoDAO;
import com.zxy.dto.CartDTO;
import com.zxy.entity.ProductInfo;
import com.zxy.enums.ProductStatusEnum;
import com.zxy.enums.ResultEnum;
import com.zxy.exception.SellException;
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

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {

		for (CartDTO cartDTO : cartDTOList) {
			//查库存
			ProductInfo productInfo = dao.findOne(cartDTO.getProductId());
			if(productInfo==null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//判断能不能减
			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if(result < 0)
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			//减库存
			productInfo.setProductStock(result);
		}
	}

	@Override
	public void increaseStock(List<CartDTO> cartDTOList) {
		// TODO Auto-generated method stub
		
	}
	
	

}
