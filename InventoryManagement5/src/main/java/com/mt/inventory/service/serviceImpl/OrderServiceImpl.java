package com.mt.inventory.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.inventory.entity.Orders;
import com.mt.inventory.entity.Stock;
import com.mt.inventory.exception.QuantityException;
import com.mt.inventory.repository.OrderRepository;
import com.mt.inventory.repository.StockRepository;
import com.mt.inventory.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
		
		@Autowired
		private OrderRepository orderRepository;
		
		@Autowired
		private StockRepository stockRepository;
		
	

		@Override
		public void saveOrder(Orders orders) {
		//	Stock stocksAvailable =new Stock();
			
			/*for(int i=0 ; i<orders.getStock().size();i++) {
			Optional<Stock> stock=Optional.ofNullable(stockRepository.findByName(orders.getStock().get(i).getName()));
			if(stock.isPresent()) {
				Stock stocks=stock.get();
				if(orders.getQuantity()>stocks.getQuantitys()) {
					throw new  QuantityException("Your quantity is greater"+stocks.getQuantitys());
				}else {
					int quantities=stocks.getQuantitys()-orders.getQuantity();
					stocks.setQuantitys(quantities);
					stockRepository.save(stocks);
				}
			}
			}*/
			
			for(int i=0;i<orders.getStock().size();i++) {
				Optional<Stock> stock=Optional.ofNullable(stockRepository.findByName(orders.getStock().get(i).getName()));
				log.info("Control in service class Order");
				if(stock.isPresent()) {
					Stock stocks=stock.get();
					if(orders.getProduct().get(i).getQuantity()>stocks.getQuantitys()) {
						log.error("You are trying to save the quantity greater than the available"+orders.getProduct().get(i).getQuantity());
						throw new  QuantityException("Your quantity is greater"+stocks.getQuantitys());
					}else {
						log.info("Going to save the data successfully");
						int quantities=stocks.getQuantitys()-orders.getProduct().get(i).getQuantity();
						stocks.setQuantitys(quantities);
						stockRepository.save(stocks);
					}
				}
			}
			
			log.info("Control in service class Order");
			this.orderRepository.save(orders);
			
		}

		@Override
		public List<Orders> getOrder() {
			log.info("Control in service class Order");
			return this.orderRepository.findAll();
		}
		
		
		
}
