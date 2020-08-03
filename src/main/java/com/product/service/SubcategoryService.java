package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.SubCategoryDao;
import com.product.model.ProductSubCategory;

@Service
public class SubcategoryService {
	
	@Autowired
	SubCategoryDao subDao;

	public ProductSubCategory registetSubCat(ProductSubCategory subcat) {
		// TODO Auto-generated method stub
		
	return	subDao.saveSubcat(subcat);
		
		
		
	}
	
	public  List<ProductSubCategory>  getSubCats() {
		
		return subDao.getSubCats();
	}

	public ProductSubCategory getSubCatById(Integer id) {
		// TODO Auto-generated method stub
		return subDao.getCatById(id);
	}

	public void updateSubCat(ProductSubCategory subCategory) {
		// TODO Auto-generated method stub
		
		subDao.updateSubCat(subCategory);
		
	}

	public void deleteSubCat(Integer id) {
		// TODO Auto-generated method stub
		
		subDao.deleteSubCat(id);
		
	}

	public List<ProductSubCategory> getSubCatCat(String cat) {
		// TODO Auto-generated method stub
		
		return subDao.getCatBySubCat(cat);
	}

}
