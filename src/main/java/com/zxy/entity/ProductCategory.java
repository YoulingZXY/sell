package com.zxy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;


@Entity
@DynamicUpdate   //动态更新，让更新日期字段可以动态更新时间
@Data	//自动生成get & set & toString方法
public class ProductCategory {

	/** 类目id. */
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	/** 类目名字. */
	private String categoryName;
	
	/** 类目编号. */
	private Integer categoryType;

	public ProductCategory(String categoryName, int category_type) {
		super();
		this.categoryName = categoryName;
		this.categoryType = category_type;
	}

	public ProductCategory() {
		super();
	}
	
	
	/** 创建时间. */
	//private Date createTime;

	/** 更新时间. */
	//private Date updateTime;

	
}
