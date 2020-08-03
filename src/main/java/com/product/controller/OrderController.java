package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.jpa.OrderJpa;
import com.product.model.OrderList;

@Controller
public class OrderController {
	@Autowired
	 private OrderJpa orderjpa;
	
	
	@GetMapping("/orders")

	public String getOrders(ModelMap map) {
		List<OrderList> list =  orderjpa.findAll();
		
		map.addAttribute("orders", list);
		return "orderlist";
		
	}

}
