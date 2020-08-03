package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.model.ProductMaster;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productdao;
	
	public ProductMaster registerProduct(ProductMaster product) {
		
		return productdao.registerProduct(product);
	}
	
	public List<ProductMaster> getAllProducts() {
		
		return productdao.getAllProducts();
	}
	
	public ProductMaster getProductById(Integer id) {
		
		return productdao.getProductById(id);
	}
	
	public void updateProduct(ProductMaster product) {
		
		 productdao.updateProduct(product);
	}
	
	public void deleteProduct(Integer id) {
		
		productdao.deleteProduct(id);
		
	}

	public List<ProductMaster> getProductsBySubCat(String subCat) {
		// TODO Auto-generated method stub
		return productdao.getProductBySubCat(subCat);
	}

	public ProductMaster getProductByName(String pro) {
		// TODO Auto-generated method stub
		return productdao.getProductByName(pro);
	}

}
