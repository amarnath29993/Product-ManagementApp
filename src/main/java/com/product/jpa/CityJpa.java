package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.City;
import com.product.model.State;
import java.util.List;

public interface CityJpa extends JpaRepository<City, Integer> {

	List<City> findByState(State state);
}
