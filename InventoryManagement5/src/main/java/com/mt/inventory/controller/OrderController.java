package com.mt.inventory.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.inventory.entity.Orders;
import com.mt.inventory.entity.Stock;
import com.mt.inventory.exception.NullCheckException;
import com.mt.inventory.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/saveOrder")
	public ResponseEntity<Void> saveOrder(@RequestBody Orders orders) {
		if (orders.getProduct() == null || orders.getProduct().isEmpty() || orders.getCustomer().getId() == 0
				|| orders.getStock() == null || orders.getStock().isEmpty()) {
			log.error("Encountered the exception due to inapproprite data u passed while ordering");
			throw new NullCheckException("Data Should not be null for order process");
		}
		for (int i = 0; i < orders.getStock().size(); i++) {
			if (orders.getStock().get(i).getName() == null || orders.getStock().get(i).getName().equals("")
					|| orders.getProduct().get(i).getQuantity() == 0) {
					log.error("Encountered the exception due to inapproprite data u passed while ordering");
					throw new NullCheckException("Data Should not be null for order process while ordering the stocks ");
			}
		}

		log.info("Going to save the data");
		this.orderService.saveOrder(orders);
		log.info("Going to save the data");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getOrder")
	public ResponseEntity<List<Orders>> getOrder() {
		log.info("Data retrieving is in process");
		List<Orders> orders = this.orderService.getOrder();
		if (orders.isEmpty()) {
			log.error("Retrieving the last should not be empty list");
			throw new NullCheckException("Retrieving the last should not be empty list");
		}
		log.info("data retrieved successfully");
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
	}
}
