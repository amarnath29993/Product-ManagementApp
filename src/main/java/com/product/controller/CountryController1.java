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

import com.product.jpa.CityJpa1;
import com.product.jpa.CountryJpa1;
import com.product.jpa.StateJpa1;
import com.product.model.City;
import com.product.model.City1;
import com.product.model.Country1;
import com.product.model.State;
import com.product.model.State1;

@Controller
public class CountryController1 {

	@Autowired
	CityJpa1 cityrepo;

	@Autowired
	StateJpa1 staterepo;

	@Autowired
	CountryJpa1 countryJpa;

	
	
	@RequestMapping(value = "/cont1",method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country1 country) {
		
		
		
		return "country";
	}

	@RequestMapping("/cont1")
	@ResponseBody
	public List<Country1> getCountryform(ModelMap map) {
		
		Country1 c1=new Country1();
		c1.setCountryId(1);
		c1.setName("India");
		
		countryJpa.save(c1);
		
		return countryJpa.findAll();
	}
	
	@RequestMapping("/city1")
	@ResponseBody
	public List<City1> getCityForm(ModelMap map) {
		
		State1 s1=staterepo.findById(106).get();
		
		City1 c1=new City1();
		c1.setName("hyderabad");
		
		Set<City1> cities=new HashSet<City1>();
		
		cities.add(c1);
		
		s1.setCities(cities);
		
		staterepo.save(s1);
		
		return cityrepo.findAll();
	}

	@RequestMapping(value = "/city1", method = RequestMethod.POST)
	public String getCountryReg(@ModelAttribute("city") City city, ModelMap map) {
		
		
		return "city";
	}

	@RequestMapping(value = "/state1",method = RequestMethod.GET)
	@ResponseBody
	public List<State1> StateForm(@ModelAttribute("state")State1 state,ModelMap map) {

		State1 s1=new State1();
		s1.setStateId(1);
		s1.setName("telangana");
		
		Set<State1> states=new HashSet<State1>();
		states.add(s1);
		
		Country1 c1=countryJpa.findById(105).get();
		c1.setStates(states);
		
		System.out.println("states "+c1);
		
		countryJpa.save(c1);
		
		
		return staterepo.findAll();
	}

	@RequestMapping(value = "/state1", method = RequestMethod.POST)
	public String saveState(ModelMap map) {

		
		return "state";
	}
	/*
	 * @RequestMapping("/cont/{name}")
	 * 
	 * @ResponseBody public List<Country> getCountryIname(@PathVariable("name")
	 * String name) {
	 * 
	 * return repo.findByName(name); }
	 */

}
