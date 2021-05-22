package com.mt.inventory.exception;

public class QuantityException extends RuntimeException{

		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public QuantityException(String message) {
			super();
			this.message = message;
		}
		
		
		
}
