package com.mt.inventory.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.inventory.entity.Customers;
import com.mt.inventory.repository.CustomersRepository;
import com.mt.inventory.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomersRepository customerRepository;

	@Override
	public void saveCustomer(Customers customer) {
		log.info("Control in service class Customer");
		this.customerRepository.save(customer);
		
	}
	
}
