package com.mt.inventory.service;

import java.util.List;

import com.mt.inventory.entity.Stock;

public interface StockService {

	void saveStock(Stock stock);

	List<Stock> getStock();

	Stock getStockByName(String name);

}
