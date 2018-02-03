package com.zxy.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

	NEW(0,"新订单"),
	FINISHED(1,"已完结订单"),
	CANCEL(2,"已取消订单")
	;
	private Integer code;
	
	private String msg;

	private OrderStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
