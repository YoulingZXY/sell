package com.zxy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zxy.entity.OrderMaster;

public interface OrderMasterDAO extends JpaRepository<OrderMaster, String>{

	/**
	 * 通过买家微信Openid(唯一的指向该买家)查询该买家的订单
	 * @param buyerOpenid
	 * @param pageable
	 * @return
	 */
	Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);
}
