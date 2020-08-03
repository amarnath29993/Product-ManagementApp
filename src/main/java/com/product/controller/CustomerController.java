package com.product.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.jpa.RoleJpa;
import com.product.jpa.UsersRepository;
import com.product.model.Address;
import com.product.model.Customer;
import com.product.model.Role;
import com.product.model.Users;
import com.product.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	RoleJpa roleJpa;
	
	@RequestMapping("/cust")
	public String formCustomer(ModelMap map) {
		
		System.out.println("CustomerController.formCustomer()");
		
		map.addAttribute("user", new Users());
		return "registration";
	}
	
	@RequestMapping(value = "/cust",method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute()Users user,ModelMap map) {
		
		//System.out.println(customer);
		//custService.registerCustomer(customer);
		
		Set<Role> roles=new HashSet<Role>();
		
		Role role=new Role();
		role.setRole("admin");
		
		roles.add(role);
		
		user.setRoles(roles);
		
		System.out.println(user);
		userRepo.save(user);
		
		map.addAttribute("user", new Users());
		return "redirect:/";
	}
	

	@RequestMapping("/customers")
	public String getCustomers(ModelMap map) {
		
		List<Customer> customers=custService.getCustomers();
		
		System.out.println(customers);
		
		map.addAttribute("customers", customers);
		return "customersList";
	}
	
	@RequestMapping("/email")
	public String emailId() {
		
		return "updateEmail";
	}
	
	@RequestMapping("/password")
	public String password() {
		
		return "updatePwd";
	}
	
	

}
