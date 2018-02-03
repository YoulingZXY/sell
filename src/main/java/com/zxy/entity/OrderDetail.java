package com.zxy.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * 订单详情表
 * 
 * @author 闻人羽
 *
 */

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

	@Id
	private String detailId;
	/** 订单id. */
	private String orderId;
	/** 商品id. */
	private String productId;
	/** 商品名字. */
	private String productName;
	/** 商品价格. */
	private BigDecimal productPrice;
	/** 商品数量. */
	private Integer productQuantity;
	/** 商品图片. */
	private String productIcon;
	/** 创建时间. */
//	private Date createTime;
	/** 修改时间.*/
//	private Date updateTime;
	public OrderDetail(String productId, Integer productQuantity) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
