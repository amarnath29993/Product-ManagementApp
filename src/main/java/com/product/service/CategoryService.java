package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.CategoryDao;
import com.product.model.ProductCategory;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao dao;
	
	public ProductCategory registerCategory(ProductCategory category) {
		
		return dao.saveCategory(category);
	}
	
	public List<ProductCategory> getAllcats() {
		
	return	dao.categorylist();
	}

	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		
		dao.deleteCat(id);
	}

	public ProductCategory getCatById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCatById(id);
	}

	public void catUpdate(ProductCategory category) {
		// TODO Auto-generated method stub
		dao.catUpdate(category);
	}

}
