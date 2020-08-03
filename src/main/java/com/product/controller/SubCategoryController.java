package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.model.ProductCategory;
import com.product.model.ProductSubCategory;
import com.product.service.CategoryService;
import com.product.service.SubcategoryService;

@Controller
public class SubCategoryController {

	@Autowired
	SubcategoryService serviceSubCat;
	
	@Autowired
	CategoryService serviceProduct;
	
	@RequestMapping("/subcategory")
	public String showSubCategory(ModelMap map) {

		System.out.println("ProductController.showSubCategory()");
		List<ProductCategory> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		List<ProductSubCategory> subCats = serviceSubCat.getSubCats();
		map.addAttribute("subcats", subCats);
		System.out.println("after cats");
		map.addAttribute("subcategory", new ProductSubCategory());
		return "subCategory";
	}
	
	@RequestMapping(value = "/subcategory",method = RequestMethod.POST)
	public String registerSubCategory(@ModelAttribute("subcategory")ProductSubCategory subcat, ModelMap map) {

		System.out.println("subCat values "+subcat);
		ProductSubCategory savedCat=serviceSubCat.registetSubCat(subcat);
		System.out.println(savedCat.getProductSubCatId()+" is saved successfully...");
		List<ProductCategory> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		List<ProductSubCategory> subcats = serviceSubCat.getSubCats();
		map.addAttribute("subcats", subcats);
		map.addAttribute("subcategory", new ProductSubCategory());
		return "subCategory";
	}
	
	@RequestMapping("/subcats")
	public String getCats(ModelMap map) {
		
		List<ProductSubCategory> subCats=serviceSubCat.getSubCats();
		System.out.println("subcategories "+subCats);
		map.addAttribute("subcats", subCats);
		List<ProductCategory> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new ProductSubCategory());
		return "subCategory";
	}
	

	@RequestMapping(value = "/deleteSubCat/{id}")
	public String categoryDelete(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println(id + " is deleted...");
		
		serviceSubCat.deleteSubCat(id);

		List<ProductSubCategory> subCats=serviceSubCat.getSubCats();
		System.out.println("subcategories "+subCats);
		map.addAttribute("subcats", subCats);
		List<ProductCategory> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new ProductSubCategory());
		return "subCategory";
	}

	@RequestMapping(value = "/updateSubCat/{id}")
	public String categoryUpdate(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println("form update "+id);
		
		ProductSubCategory  subCategory=serviceSubCat.getSubCatById(id);
		List<ProductSubCategory> subCats=serviceSubCat.getSubCats();
		System.out.println("subcategories "+subCats);
		map.addAttribute("subcats", subCats);
		map.addAttribute("subcategory", subCategory);
		return "subCategoryUpdate";
	}
	
	@RequestMapping(value = "/updateSubCat",method = RequestMethod.POST)
	public String categoryUpdating(@ModelAttribute("subCategory")ProductSubCategory subCategory, ModelMap map) {

		System.out.println(subCategory);
		serviceSubCat.updateSubCat(subCategory);
		
		List<ProductSubCategory> subCats=serviceSubCat.getSubCats();
		System.out.println("subcategories "+subCats);
		map.addAttribute("subcats", subCats);
		List<ProductCategory> cats = serviceProduct.getAllcats();
		map.addAttribute("cats", cats);
		map.addAttribute("subcategory", new ProductSubCategory());
		return "subCategory";
	}

}
