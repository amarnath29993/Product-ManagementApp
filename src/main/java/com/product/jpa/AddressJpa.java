package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Address;
import java.lang.String;
import java.util.List;

public interface AddressJpa extends JpaRepository<Address, Integer> {

	
	List<Address> findByUserName(String username);
}
