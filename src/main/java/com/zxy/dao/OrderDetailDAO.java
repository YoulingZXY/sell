package com.zxy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, String>{

	/**
	 * 通过订单主表的ID(唯一的指向一张订单)查询该订单下的所有商品订单
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> findByOrderId(String orderId);
}
