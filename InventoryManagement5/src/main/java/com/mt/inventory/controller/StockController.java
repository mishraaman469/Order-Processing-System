package com.mt.inventory.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.inventory.entity.Stock;
import com.mt.inventory.exception.NullCheckException;
import com.mt.inventory.exception.StockNotFoundException;
import com.mt.inventory.service.StockService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/saveStock")
	public ResponseEntity<Void> saveStock(@RequestBody Stock stock) {
		if (stock.getName() == null || stock.getName().equals("") || stock.getPrice() == 0
				|| stock.getProductType() == null	|| stock.getProductType().equals("")   || stock.getQuantitys()==0) {
			log.error("Encountered exception due to passing the null or empty fields while registering the stocks");
			throw new NullCheckException("Data Should not be null while registering the stocks");
		}
			log.info("Going to save th data" + stock.getName());
		this.stockService.saveStock(stock);
		log.info("data saved successfully" + stock.getName());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getStock")
	public ResponseEntity<List<Stock>> getStock() {
		log.info("Data retrieving is in process");
		List<Stock> stock = this.stockService.getStock();
		if(stock.isEmpty()) {
			log.error("Encountered Exception You are trying to retry the empty list");
			throw new NullCheckException("You are trying to retry the empty list");
		}
		log.info("data retrieved successfully");
		List<Stock> stocks = stock.stream().sorted(new Stock()::compare).collect(Collectors.toList());
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}

	@GetMapping("/getByStockName/{name}")
	public ResponseEntity<Stock> getStockByName( @PathVariable String name) {
		if(name.isEmpty()||name==null ||name.equals(" ")  ) {
			log.error("Encountered Exception while retrieving the data by particular name");
			throw new NullCheckException("Name field should not be empty while retrieving the data");
		}
		log.info("Data retrieving is in process" + name);
		Stock stock = this.stockService.getStockByName(name);
		log.info("data retrieved successfully" + name);
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
}
