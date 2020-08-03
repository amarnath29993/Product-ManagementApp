package com.product.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.jpa.UsersRepository;
import com.product.model.Address;
import com.product.model.City;
import com.product.model.Country;
import com.product.model.State;
import com.product.model.Users;
import com.product.service.AddressService;
import com.product.service.CustomerService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressServie;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	UsersRepository userJpa;
	
	
	@RequestMapping("/address")
	public String formAddress(HttpServletRequest req,ModelMap map) {
		
		 Principal userPrincipal = req.getUserPrincipal();
		 
		 if(req.getUserPrincipal()!=null) {
		 System.out.println(userPrincipal.getName());
		 
		 Optional<Users>  user= userJpa.findByEmailId(userPrincipal.getName());
		 
		 System.out.println(user);
		 
		 }
		
		List<Country> countries=addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		return "address";
	}
	
	@RequestMapping(value = "/address",method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add")Address address,HttpServletRequest p,ModelMap map) {
		
		Users user=userJpa.findByEmailId(p.getUserPrincipal().getName()).get();
		address.setUserName(user.getEmailId());
		
		custService.saveAddress(address);
		
		
		map.addAttribute("add", new Address());
		return "address";
	}
	
	@RequestMapping("/getStates/{id}")
	@ResponseBody
	public List<State> getStates(@PathVariable("id")Integer countryId,ModelMap map) {
		
		
		List<State> countries=addressServie.getStatesByCountryId(countryId);
		return countries;
	}
	
	@RequestMapping("/getCities/{id}")
	@ResponseBody
	public List<City> getCites(@PathVariable("id")Integer countryId,ModelMap map) {
		
		
		List<City> cities=addressServie.getCitiesByStateId(countryId);
		
		return cities;
	}

}
