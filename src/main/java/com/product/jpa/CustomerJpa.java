package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Customer;

public interface CustomerJpa extends JpaRepository<Customer, Integer> {

}
