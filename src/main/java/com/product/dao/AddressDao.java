package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.jpa.AddressJpa;
import com.product.jpa.CityJpa;
import com.product.jpa.CountryJpa;
import com.product.jpa.StateJpa;
import com.product.model.Address;
import com.product.model.City;
import com.product.model.Country;
import com.product.model.State;

@Repository
public class AddressDao {
	
	@Autowired
	CountryJpa countryJpa;
	
	@Autowired
	StateJpa stateJpa;
	
	@Autowired
	CityJpa cityJpa;
	@Autowired
	AddressJpa addressJpa;
	
	public List<Country> getCountries(){
		
		return countryJpa.findAll();
	}


	public List<State> getStatesByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		
		return stateJpa.findByCountry(countryJpa.findById(countryId).get());
	}


	public List<City> getCitiesByStateId(Integer stateId) {
		// TODO Auto-generated method stub
		return cityJpa.findByState(stateJpa.findById(stateId).get());
	}
	
	public void saveCountry() {
		
		countryJpa.save(null);
	}


	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return addressJpa.findAll();
	}

}
