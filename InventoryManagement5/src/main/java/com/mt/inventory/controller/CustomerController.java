package com.mt.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.inventory.entity.Customers;
import com.mt.inventory.entity.Stock;
import com.mt.inventory.exception.NullCheckException;
import com.mt.inventory.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	
	@Autowired	
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Void> saveCustomer(@RequestBody Customers customer){
	
		if(customer.getName()==null||customer.getName().equals("")) {
			log.error("Data while saving the cutomer name should not be empty");
			throw new NullCheckException("Data while saving the cutomer name should not be empty"+customer.getName());
		}
		log.info("Going to save the data"+customer.getName());
		this.customerService.saveCustomer(customer);
		log.info("successfully save the data"+customer.getName());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	
}
