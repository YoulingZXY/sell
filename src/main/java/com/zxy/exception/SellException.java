package com.zxy.exception;

import com.zxy.enums.ResultEnum;

import lombok.Data;

@Data
public class SellException extends RuntimeException{

	/** 错误码 */
	private Integer code;
	
	public SellException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = code;
	}
	
	
}
