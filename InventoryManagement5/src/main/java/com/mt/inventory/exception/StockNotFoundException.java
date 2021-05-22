package com.mt.inventory.exception;

public class StockNotFoundException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StockNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
