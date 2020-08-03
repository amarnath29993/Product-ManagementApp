package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.jpa.AddressJpa;
import com.product.jpa.OrderJpa;
import com.product.jpa.UsersRepository;
import com.product.model.Address;
import com.product.model.Country;
import com.product.model.OrderList;
import com.product.model.ProductCategory;
import com.product.model.ProductMaster;
import com.product.model.ProductSubCategory;
import com.product.service.AddressService;
import com.product.service.CategoryService;
import com.product.service.CustomerService;
import com.product.service.ProductService;
import com.product.service.SubcategoryService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;
	
	@Autowired
	AddressService addressServie;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	UsersRepository userJpa;
	
	@Autowired
	OrderJpa orderJpa;
	
	@Autowired
	AddressJpa addJpa;
	
	@RequestMapping("/cart/{id}")
	public String addToCart(@PathVariable("id")String pro, HttpServletRequest request,ModelMap map) {
		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		ProductMaster proMaster=productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+proMaster.getProductSubCat());
		
		return "redirect:/"+proMaster.getProductSubCat();
		
	}
	
	@RequestMapping("/carts")
	public String showCarts(HttpServletRequest request,ModelMap map) {
		
		List<ProductMaster> carts=new ArrayList<ProductMaster>();
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		for (String pro : pros) {
			ProductMaster product=productService.getProductByName(pro);
			
			carts.add(product);
		}
		System.out.println("carts products");
		System.out.println(carts);
		map.addAttribute("carts", carts);
		
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		
		
		return "cart";
	}
	@RequestMapping("/cartremove/{id}")
	public String removeToCart(@PathVariable("id")String pro, HttpServletRequest request,ModelMap map) {
		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.remove(pro);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		ProductMaster proMaster=productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+proMaster.getProductSubCat());
		
		return "redirect:/carts";		
	}
	@RequestMapping("/proceed")
	public String proceed(HttpServletRequest request,ModelMap map) {
		
		System.out.println("hh    "+request.getUserPrincipal().getName());
	
		
		List<Country> countries=addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		if(request.getUserPrincipal()!=null) {
			map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get().getUserName());
			}
			else {
				map.addAttribute("user", null);
			}
        List<Address> ads = addJpa.findByUserName(request.getUserPrincipal().getName());
        System.out.println(ads);
        	map.addAttribute("ads", ads);
        
		return "proceed";
	}
	@RequestMapping("/buy")
	
	public String buyProduct() {
		return "payment";
		
	}
	@RequestMapping("/purchase")
	
	public String purchaseProduct(HttpServletRequest request,ModelMap map ){
		

	List<ProductMaster> carts=new ArrayList<ProductMaster>();
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		for (String pro : pros) {
			ProductMaster product=productService.getProductByName(pro);
			
			carts.add(product);
		}
		
		for (ProductMaster product : carts) {
			
			OrderList order=new OrderList();
			
			order.setProductId(product.getProductId());
			order.setPriceEach(product.getPrice());
			
			orderJpa.save(order);
			
		}
		
		System.out.println("carts products");
		System.out.println(carts);
		map.addAttribute("pros", carts);
		
			
		return "/purchase";
		
	}
	
	@RequestMapping(value = "/newaddress",method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add")Address address,ModelMap map,HttpServletRequest request) {
		System.err.println(request.getUserPrincipal().getName());
		address.setUserName(request.getUserPrincipal().getName());
		custService.saveAddress(address);
		
		
		map.addAttribute("add", new Address());
		return "payment";
	}
	

}
