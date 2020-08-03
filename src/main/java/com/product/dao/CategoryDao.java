package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.jpa.CategoryJpa;
import com.product.model.ProductCategory;

@Repository
public class CategoryDao {

	@Autowired
	CategoryJpa repository;
	
	public ProductCategory saveCategory(ProductCategory category) {
		
		return repository.save(category);
	}
	
	public List<ProductCategory> categorylist() {
		
		return repository.findAll();
	}

	public void deleteCat(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	public ProductCategory getCatById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public void catUpdate(ProductCategory category) {
		// TODO Auto-generated method stub
		repository.save(category);
	}
}
