package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.model.ProductCategory;
import com.product.model.ProductMaster;
import com.product.model.ProductSubCategory;
import com.product.service.CategoryService;
import com.product.service.ProductService;
import com.product.service.SubcategoryService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;

	@RequestMapping("/formProduct")
	public String formProduct(ModelMap map) {

		System.out.println("ProductController.formProduct()");

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);
System.out.println("after cats");
		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);
		System.out.println("after subcats");
		
		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		System.out.println("after pros");
		
		map.addAttribute("product", new ProductMaster());
		System.out.println("after all");
		return "product";
	}

	@RequestMapping("/saveProduct")
	public String registerProduct(@ModelAttribute("product") ProductMaster product, ModelMap map) {

		System.out.println(product);

		ProductMaster saved = productService.registerProduct(product);

		System.out.println("product value is " + saved.getProductId());

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);
		
		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		map.addAttribute("product", new ProductMaster());
		return "product";
	}

	@RequestMapping("/getProducts")
	public String getAllProducts(ModelMap map) {

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		map.addAttribute("product", new ProductMaster());

		return "product";
	}

	@RequestMapping("/updateProduct/{id}")
	public String getproductById(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println("from update " + id);
		ProductMaster proMaster = productService.getProductById(id);
		System.out.println(proMaster);

		map.addAttribute("product", proMaster);

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);

		return "updateProduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") ProductMaster proMaster, ModelMap map) {

		productService.updateProduct(proMaster);
		
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new ProductMaster());
		return "product";

	}

	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Integer id,ModelMap map) {

		productService.deleteProduct(id);

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("categories", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new ProductMaster());

		return "product";
	}
	
	@RequestMapping("/subcats/{id}")
	@ResponseBody
	public List<ProductSubCategory> getSubCatByCat(@PathVariable("id") String cat){
		
		System.out.println("enter value is "+cat);
		
		List<ProductSubCategory> subCats=SubcategoryService.getSubCatCat(cat);
		
		System.out.println(subCats);
		
		return subCats;
	}

}
