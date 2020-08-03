package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.ProductCategory;

public interface CategoryJpa extends JpaRepository<ProductCategory, Integer> {

}
