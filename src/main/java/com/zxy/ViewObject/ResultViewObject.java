package com.zxy.ViewObject;

import lombok.Data;

/**
 * http 请求返回的 最外层对象
 * 
 * @author 闻人羽
 *
 */
@Data
public class ResultViewObject<T> {

	/** 错误码. */
	private Integer code;
	
	/** 提示信息. */
	private String msg;
	
	/** 具体内容. */
	private T data;
}
