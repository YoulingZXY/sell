package com.zxy.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

	PRODUCT_NOT_EXIST(1,"商品不存在"),
	PRODUCT_STOCK_ERROR(2,"商品库存错误"),
	ORDER_NOT_EXIST(3,"订单不存在"),
	ORDERDETAIL_NOT_EXIST(4,"订单详情不存在")
	;
	
	private Integer code;
	
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
