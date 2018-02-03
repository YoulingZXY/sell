package com.zxy.dto;

import lombok.Data;

/**
 * 购物车传输对象
 * 作用：用于传输买家购买的商品id、数量
 * @author 闻人羽
 *
 */
@Data
public class CartDTO {

	private String productId;
	
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
	
}
