package com.mt.inventory.service;

import java.util.List;

import com.mt.inventory.entity.Orders;

public interface OrderService {

	void saveOrder(Orders orders);

	List<Orders> getOrder();

}
