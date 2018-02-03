package com.zxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.ViewObject.ProductCategoryViewObject;
import com.zxy.ViewObject.ProductInfoViewObject;
import com.zxy.ViewObject.ResultViewObject;
import com.zxy.entity.ProductCategory;
import com.zxy.entity.ProductInfo;
import com.zxy.service.ProductCategoryService;
import com.zxy.service.ProductInfoService;
import com.zxy.utils.ResultUtil;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
	
	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping("list")
	public ResultViewObject list() {
		
		//查询所有在架商品
		List<ProductInfo> productInfoList = productInfoService.findUpAll();
		
		//查询所有在架商品的类目编号~~~~~~~~~更精简方法，lambda表达式，有待学习！！！
		List<Integer> categoryTypeList = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList) {
			categoryTypeList.add(productInfo.getCategoryType());
		}
		
		//获得所有在架商品的类目信息，注：find xxx By xxx In() 方法会自动去重
		List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
		
		//~~~~~~~~~~~~~数据拼装~~~~~~~~~~~~~~
		
		//创建响应对象，最外层骨架
//		ResultViewObject result = new ResultViewObject();
		//写入错误码，0为正常
//		result.setCode(0);
		//写入提示信息
//		result.setMsg("成功");
			//创建data对象,中层骨架
			List<ProductCategoryViewObject> data = new ArrayList<>();
			//遍历所有在架商品的类目列表
			for (ProductCategory productCategory : productCategoryList) {
				//创建响应类目对象
				ProductCategoryViewObject productCategoryViewObject = new ProductCategoryViewObject();
				//写入类目名字
				productCategoryViewObject.setCategoryName(productCategory.getCategoryName());
				//写入类目编号
				productCategoryViewObject.setCategoryType(productCategory.getCategoryType());
					//创建foots对象，内层骨架
					List<ProductInfoViewObject> foots = new ArrayList<>();
					//遍历所有在架商品列表
					for (ProductInfo productInfo : productInfoList) {
						//判断如果该商品的类目编号等于当前类目的编号，则添加到当前类目的foots列表下
						if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
							//创建相应商品对象
							ProductInfoViewObject productInfoViewObject = new ProductInfoViewObject();
							//数据拷贝，写入商品相关数据
							BeanUtils.copyProperties(productInfo, productInfoViewObject);
							//填充内层骨架
							foots.add(productInfoViewObject);
						}
					}
				//写入foots对象
				productCategoryViewObject.setProductInfoViewObjectList(foots);
				//填充中层骨架
				data.add(productCategoryViewObject);
			}
		//写入data对象
//		result.setData(data);
		return ResultUtil.success(data);
	}
}
