package com.product.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@RequestMapping("/category")
	public String showCategory(ModelMap map) {

		
		  System.out.println("ProductController.showcategory()"); List<ProductCategory>
		  cats = service.getAllcats(); map.addAttribute("cats", cats);
		  map.addAttribute("category", new ProductCategory());
		 
		return "category";
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String RegisterCategory(@ModelAttribute("category") ProductCategory category, ModelMap map) {

		System.out.println(category);
		ProductCategory cat = service.registerCategory(category);
		System.out.println(cat.getProductCategoryId() + " is saved....");
		map.addAttribute("category", new ProductCategory());
		List<ProductCategory> cats = service.getAllcats();
		map.addAttribute("cats", cats);
		return "category";
	}

	

	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categorylist(ModelMap map) {
		List<ProductCategory> cats = service.getAllcats();

		System.out.println(cats);

		map.addAttribute("cats", cats);
		map.addAttribute("category", new ProductCategory());
		return "category";
	}

	@RequestMapping(value = "/delete/{id}")
	public String categoryDelete(@PathVariable("id") Integer id, ModelMap map) {

		System.out.println(id + " is deleted...");

		service.deleteCategory(id);

		List<ProductCategory> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("category", new ProductCategory());
		return "category";
	}

	@RequestMapping(value = "/update/{id}")
	public String categoryUpdate(@PathVariable("id") Integer id, ModelMap map) {

		ProductCategory proCat=service.getCatById(id);
		
		List<ProductCategory> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("category", proCat);
		System.out.println(id + " is updated...");
		return "categoryUpdate";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String categoryUpdating(@ModelAttribute("category") ProductCategory category, ModelMap map) {

		service.catUpdate(category);
		
		List<ProductCategory> cats = service.getAllcats();

		map.addAttribute("cats", cats);
		map.addAttribute("category", new ProductCategory());
		System.out.println(category.getProductCategoryId() + " is updated...");
		return "category";
	}

}
