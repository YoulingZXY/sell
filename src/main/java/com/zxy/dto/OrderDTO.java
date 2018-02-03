package com.zxy.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.zxy.entity.OrderDetail;
import com.zxy.enums.OrderStatusEnum;
import com.zxy.enums.PayStatusEnum;

import lombok.Data;

@Data
public class OrderDTO {

	/** 订单id. */
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
	private Integer orderStatus;
	/** 支付状态，默认为0，等待支付状态. */
	private Integer payStatus;
	/** 创建时间. */
	private Date createTime;
	/** 更新时间. */
	private Date updateTime;
	
	/** 订单详情 */
	private List<OrderDetail> orderDetailList;
}
