package com.zxy.ViewObject;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * http请求返回的最内层商品信息，为了安全性考虑，不返回过多的字段信息，特建此对象，以区别entity实体。
 * 
 * @author 闻人羽
 *
 */
@Data
public class ProductInfoViewObject {

	@JsonProperty("id")
	private String productId;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("price")
	private BigDecimal productPrice;
	
	@JsonProperty("description")
	private String productDiscription;
	
	@JsonProperty("icon")
	private String productIcon;
	
}
