package com.mt.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.inventory.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	Stock findByName(String name);

	
	
}
