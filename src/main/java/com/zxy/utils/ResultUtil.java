package com.zxy.utils;

import com.zxy.ViewObject.ResultViewObject;

public class ResultUtil {

	public static ResultViewObject success(Object object) {
		
		ResultViewObject result = new ResultViewObject();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}
	
	public static ResultViewObject success() {
		
		return success(null);
		
	}
	
	public static ResultViewObject error(Integer code,String msg) {
		
		ResultViewObject result = new ResultViewObject();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
