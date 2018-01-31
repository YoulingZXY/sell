package com.zxy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxy.ViewObject.ProductInfoViewObject;
import com.zxy.ViewObject.ProductViewObiect;
import com.zxy.ViewObject.ResultViewObject;
import com.zxy.entity.ProductCategory;
import com.zxy.entity.ProductInfo;
import com.zxy.service.ProductCategoryService;
import com.zxy.service.ProductInfoService;

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
		//查询所有在架商品的类目
		List<Integer> categoryTypeList = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList) {
			categoryTypeList.add(productInfo.getCategoryType());
		}
		List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
		//数据拼装
		//~1、中层data数据
			//创建data数据列表
		List<ProductViewObiect> productViewObiectList = new ArrayList<>();
			//遍历类目列表
		for (ProductCategory productCategory : productCategoryList) {
			//创建类目元素（包含类目名字，类目编号，foots(具体商品信息)）
			ProductViewObiect pvo = new ProductViewObiect();
			//写入类目名字
			pvo.setCategoryName(productCategory.getCategoryName());
			//写入类目编号
			pvo.setCategoryType(productCategory.getCategoryType());
			//~2、内层foots数据，具体商品信息列表
			//创建foots数据列表
			List<ProductInfoViewObject> productInfoViewObjectList = new ArrayList<>();
			//遍历商品列表
			for (ProductInfo productInfo : productInfoList) {
				//如果该商品类目等于当前类目，则加入foots列表
				if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoViewObject pivo = new ProductInfoViewObject();
					//数据拷贝
					BeanUtils.copyProperties(productInfo, pivo);
					//加入foots
					productInfoViewObjectList.add(pivo);
				}
			}
			//写入当前类目列表
			pvo.setProductInfoViewObjectList(productInfoViewObjectList);
			//把封装好的类目数据写入data列表
			productViewObiectList.add(pvo);
		}
		
		//创建http响应最外层对象
		ResultViewObject result = new ResultViewObject();
		result.setCode(0);
		result.setMsg("成功");
		//把中层数据列表写入data
		result.setData(productViewObiectList);
		return result;
	}
}
