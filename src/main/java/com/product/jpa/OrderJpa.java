package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.OrderList;

public interface OrderJpa extends JpaRepository<OrderList, Integer> {

}
