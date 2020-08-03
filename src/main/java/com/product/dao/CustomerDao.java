package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.jpa.AddressJpa;
import com.product.jpa.CustomerJpa;
import com.product.model.Address;
import com.product.model.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerJpa custJpa;
	
	@Autowired
	AddressJpa addJpa;

	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		custJpa.save(customer);
		
	}
	
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		return custJpa.findAll();
	}

	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		addJpa.save(address);
	}


}
