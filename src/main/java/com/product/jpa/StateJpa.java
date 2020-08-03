package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.State;
import com.product.model.Country;
import java.util.List;

public interface StateJpa extends JpaRepository<State, Integer> {
	
	List<State> findByCountry(Country country);

}
