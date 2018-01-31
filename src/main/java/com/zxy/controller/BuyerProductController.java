package com.zxy.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.ViewObject.ProductInfoViewObject;
import com.zxy.ViewObject.ProductViewObiect;
import com.zxy.ViewObject.ResultViewObject;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

	@GetMapping("list")
	public ResultViewObject list() {
		ResultViewObject result = new ResultViewObject();
		ProductViewObiect pvo = new ProductViewObiect();
		ProductInfoViewObject pivo = new ProductInfoViewObject();
		pvo.setProductInfoViewObjectList(Arrays.asList(pivo));
		result.setCode(0);
		result.setMsg("成功");
		
		result.setData(Arrays.asList(pvo));
		return result;
	}
}
