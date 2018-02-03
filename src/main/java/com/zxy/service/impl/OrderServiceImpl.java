package com.zxy.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.dao.OrderDetailDAO;
import com.zxy.dao.OrderMasterDAO;
import com.zxy.dto.CartDTO;
import com.zxy.dto.OrderDTO;
import com.zxy.entity.OrderDetail;
import com.zxy.entity.OrderMaster;
import com.zxy.entity.ProductInfo;
import com.zxy.enums.OrderStatusEnum;
import com.zxy.enums.PayStatusEnum;
import com.zxy.enums.ResultEnum;
import com.zxy.exception.SellException;
import com.zxy.service.OrderService;
import com.zxy.service.ProductInfoService;
import com.zxy.utils.KeyUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private OrderMasterDAO orderMasterDao;
	@Autowired
	private OrderDetailDAO oederDetailDao;
	
	@Override
	public OrderDTO create(OrderDTO orderDTO) {

		//生成订单Id
		String orderId = KeyUtil.getUniqueKey();
		
		//购物车清单，用于加减库存~~~更精简方法，lambda表达式，有待学习！！！
		List<CartDTO> cartDTOList = new ArrayList<>();
		
		//查询商品（商品是否存在、商品单价）
		//定义订单总价变量，初始化0
		BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
		//遍历订单内的商品列表
		for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			//判断商品是否存在,如果不存在则抛异常
			ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
			if(productInfo==null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			//订单详情入库
			orderDetail.setDetailId(KeyUtil.getUniqueKey());
			orderDetail.setOrderId(orderId);
			BeanUtils.copyProperties(productInfo, orderDetail);
			oederDetailDao.save(orderDetail);
			//计算订单总价
			BigDecimal productPrice = productInfo.getProductPrice();	//商品单价
			BigDecimal productQuantity = new BigDecimal(orderDetail.getProductQuantity());	//要购买的数量
			BigDecimal sum = productPrice.multiply(productQuantity);	//计算结果(乘积) 
			orderAmount = 	sum.add(orderAmount);	//把每次计算的结果（每张子订单的商品数量）累加到订单总价中
			
			//每遍历出一张订单详情表后，就将该商品ID和数量存入CartDTOList~~~更精简方法，lambda表达式，有待学习！！！
			cartDTOList.add(new CartDTO(productInfo.getProductId(),orderDetail.getProductQuantity()));
		}
		//写入数据库 OrderMaster
		OrderMaster orderMaster = new OrderMaster();
		/** 此处注意，数据拷贝一定要优先与set方法进行，
		 * 否则被拷贝对象中一旦有属性值是null，也会拷贝，
		 * 这样就覆盖掉了之前的set方法的赋值 */
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderId(orderId);
		orderMaster.setOrderAmount(orderAmount);
		/** 由于订单状态是采用初始化赋值，所以在数据拷贝后需要重新赋值 */
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterDao.save(orderMaster);
		
		//减少库存~~~更精简方法，lambda表达式，有待学习！！！
		productInfoService.decreaseStock(cartDTOList);
		
		return orderDTO;
	}

	@Override
	public OrderDTO findOne(String orderId) {
		
		OrderMaster orderMaster = orderMasterDao.findOne(orderId);
		if(orderMaster==null)
			throw new SellException(ResultEnum.ORDER_NOT_EXIST);
		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		List<OrderDetail> orderDetailList = oederDetailDao.findByOrderId(orderMaster.getOrderId());
		if(orderDetailList.size()==0)
			throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}

	@Override
	/**
	 * 如果不需要查询订单详情，那么还需要返回OrderDTO对象的集合么？
	 * DTO对象只比实体对象多出一个订单详情列表
	 * */
	public Page<OrderMaster> findList(String buyerOpenid, Pageable pageable) {
		
		return orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
	}

	@Override
	public OrderDTO cancle(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO finish(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO paid(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
