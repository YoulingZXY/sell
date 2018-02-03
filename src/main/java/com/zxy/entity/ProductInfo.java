package com.zxy.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * 商品详情表
 * 
 * @author 闻人羽
 *
 */

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

	@Id
	private String productId ;
	
	/** 商品名称. */
	private String productName;
	
	/** 商品价格. */
	private BigDecimal productPrice;
	
	/** 商品库存. */
	private Integer productStock;
	
	/** 商品描述. */
	private String productDescription;
	
	/** 商品图片. */
	private String productIcon;
	
	/** 商品状态，0正常，1下架. */
	private Integer productStatus;
	
	/** 类目编号. */
	private Integer categoryType;
	
	/** 创建时间. */
	//private Date createTime;
	
	/** 修改时间. */
	//private Date updateTime;
}
