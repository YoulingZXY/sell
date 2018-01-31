package com.zxy.ViewObject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * http请求返回的数据的中层数据（包含类目）
 * 
 * @author 闻人羽
 *
 */
@Data
public class ProductViewObiect {

	/** 为了可读性好，此处把名字具体化，但返回给浏览器的json字符串名字不变*/
	@JsonProperty("name")
	private String categoryName;
	
	@JsonProperty("type")
	private Integer categoryType;
	
	@JsonProperty("foots")
	private List<ProductInfoViewObject> productInfoViewObjectList;
}
