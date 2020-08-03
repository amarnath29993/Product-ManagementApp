package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productSubCatId;
	
	private String productCategory;

	private String productSubCat;

	private String productSubCatDesc;

	public Integer getProductSubCatId() {
		return productSubCatId;
	}

	public void setProductSubCatId(Integer productSubCatId) {
		this.productSubCatId = productSubCatId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCat() {
		return productSubCat;
	}

	public void setProductSubCat(String productSubCat) {
		this.productSubCat = productSubCat;
	}

	public String getProductSubCatDesc() {
		return productSubCatDesc;
	}

	public void setProductSubCatDesc(String productSubCatDesc) {
		this.productSubCatDesc = productSubCatDesc;
	}

	@Override
	public String toString() {
		return "ProductSubCategory [productSubCatId=" + productSubCatId + ", productCategory=" + productCategory
				+ ", productSubCat=" + productSubCat + ", productSubCatDesc=" + productSubCatDesc + "]";
	}



}
