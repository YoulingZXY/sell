package com.zxy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zxy.dto.OrderDTO;
import com.zxy.entity.OrderMaster;

public interface OrderService {

	/** 创建订单 */
	OrderDTO create(OrderDTO orderDTO);
	
	/** 查询单个订单 */
	OrderDTO findOne(String orderId);
	
	/** 查询订单列表 */
	/**
	 * 如果不需要查询订单详情，那么还需要返回OrderDTO对象的集合么？
	 * DTO对象只比实体对象多出一个订单详情列表
	 * */
	Page<OrderMaster> findList(String buyerOpenid,Pageable pageable);
	
	/** 取消订单 */
	OrderDTO cancle(OrderDTO orderDTO);
	
	/** 完结订单 */
	OrderDTO finish(OrderDTO orderDTO);

	/** 支付订单 */
	OrderDTO paid(OrderDTO orderDTO);
}
