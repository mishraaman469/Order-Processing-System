package com.mt.inventory.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockWebController {
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/customer")
	public String customerPage() {
		return "customer";
	}
	
	@GetMapping("/order")
	public String orderPage() {
		return "order";
	}
	
	@GetMapping("/stock")
	public String stockPage() {
		return "stock";
	}
	@GetMapping("/getStockAll")
	public String getstockPage() {
		return "GetStock";
	}
	
	@GetMapping("/getByStockName")
	public String getstockNamePage() {
		return "GetStockName";
	}
}
