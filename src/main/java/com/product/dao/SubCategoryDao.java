package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.jpa.SubCategoryJpa;
import com.product.model.ProductSubCategory;

@Repository
public class SubCategoryDao {

	@Autowired
	SubCategoryJpa subCatRepo;

	public ProductSubCategory saveSubcat(ProductSubCategory subcat) {
		// TODO Auto-generated method stub
		
		return subCatRepo.save(subcat);
	}
	
	public List<ProductSubCategory> getSubCats() {
		
		return subCatRepo.findAll();
	}

	public ProductSubCategory getCatById(Integer id) {
		// TODO Auto-generated method stub
		return subCatRepo.findById(id).get();
	}

	public void updateSubCat(ProductSubCategory subCategory) {
		// TODO Auto-generated method stub
		
		subCatRepo.save(subCategory);
	}

	public void deleteSubCat(Integer id) {
		// TODO Auto-generated method stub
		subCatRepo.deleteById(id);
		
	}
	
	public List<ProductSubCategory> getCatBySubCat(String cat) {
		
		List<ProductSubCategory> subCats=subCatRepo.findByProductCategory(cat);
		
		//System.out.println(subCats);
		
		return subCats;
	}
	
}
