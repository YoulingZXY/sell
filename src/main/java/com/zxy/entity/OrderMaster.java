package com.zxy.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import com.zxy.enums.OrderStatusEnum;
import com.zxy.enums.PayStatusEnum;

import lombok.Data;

/**
 * 订单主表
 * 
 * @author 闻人羽
 *
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

	/** 订单id. */
	@Id
	private String orderId;
	/** 买家名字. */
	private String buyerName;
	/** 买家电话. */
	private String buyerPhone;
	/** 买家地址. */
	private String buyerAddress;
	/** 买家微信openid. */
	private String buyerOpenid;
	/** 订单总金额. */
	private BigDecimal orderAmount;
	/** 订单状态，默认为0，新下单状态. */
	private Integer orderStatus = OrderStatusEnum.NEW.getCode() ;
	/** 支付状态，默认为0，等待支付状态. */
	private Integer payStatus = PayStatusEnum.WAIT.getCode();
	/** 创建时间. */
	private Date createTime;
	/** 更新时间. */
	private Date updateTime;
}
