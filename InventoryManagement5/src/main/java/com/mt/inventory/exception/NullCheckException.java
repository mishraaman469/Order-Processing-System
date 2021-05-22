package com.mt.inventory.exception;

public class NullCheckException extends RuntimeException{

		private String message;

		public NullCheckException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
}
