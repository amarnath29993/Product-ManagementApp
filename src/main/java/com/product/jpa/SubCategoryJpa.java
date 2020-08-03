package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.ProductSubCategory;
import java.lang.String;
import java.util.List;

public interface SubCategoryJpa extends JpaRepository<ProductSubCategory, Integer> {

	public List<ProductSubCategory> findByProductCategory(String productcategory);
}
