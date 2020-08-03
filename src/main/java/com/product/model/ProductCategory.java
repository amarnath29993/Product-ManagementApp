package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productCategoryId;
	
	private String productCategory;
	
	private String productCatDesc;

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCatDesc() {
		return productCatDesc;
	}

	public void setProductCatDesc(String productCatDesc) {
		this.productCatDesc = productCatDesc;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId + ", productCategory=" + productCategory
				+ ", productCatDesc=" + productCatDesc + "]";
	}
	
	

	
}
