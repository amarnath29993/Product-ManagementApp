package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.AddressDao;
import com.product.model.Address;
import com.product.model.City;
import com.product.model.Country;
import com.product.model.State;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	public List<Country> getCountries(){
		
		return addressDao.getCountries();
	}

	public List<State> getStatesByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		return addressDao.getStatesByCountryId(countryId);
	}

	public List<City> getCitiesByStateId(Integer countryId) {
		// TODO Auto-generated method stub
		return addressDao.getCitiesByStateId(countryId);
	}

	public List<Address> getAllAddress() {
	 return addressDao.getAllAddress();
		
	}
	
}
